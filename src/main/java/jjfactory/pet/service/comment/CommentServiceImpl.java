package jjfactory.pet.service.comment;

import jjfactory.pet.domain.board.Board;
import jjfactory.pet.domain.comment.Comment;
import jjfactory.pet.domain.user.User;
import jjfactory.pet.repository.board.BoardRepository;
import jjfactory.pet.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public Comment getComment(Long id){
        Comment findComment = commentRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("조회할 수 없습니다");
        });
        return findComment;
    }

    @Override
    public List<Comment> getCommentList(){
        List<Comment> commentList = commentRepository.findAll();
        return commentList;
    }

    @Override
    @Transactional
    public void save(Comment comment, User user, Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> {
            return new IllegalArgumentException("게시글 조회실패");
        });

        log.info("user = {} , board = {}",user.getId(),board.getId());

        comment.setUser(user);
        comment.setBoard(board);
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
