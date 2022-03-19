package jjfactory.pet.service.comment;

import jjfactory.pet.domain.comment.Comment;
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
    public void save(Comment comment){
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
