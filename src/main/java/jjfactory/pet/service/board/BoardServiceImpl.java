package jjfactory.pet.service.board;

import jjfactory.pet.domain.board.Board;
import jjfactory.pet.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Board getBoard(Long id){
        Board findBoard = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("게시물을 찾을 수 없습니다");
        });
        return findBoard;
    }

    public List<Board> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    @Transactional
    @Override
    public void save(Board board){
        boardRepository.save(board);
    }

    @Transactional
    @Override
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
}
