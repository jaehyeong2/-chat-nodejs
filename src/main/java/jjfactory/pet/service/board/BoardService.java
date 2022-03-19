package jjfactory.pet.service.board;

import jjfactory.pet.domain.board.Board;
import jjfactory.pet.domain.user.User;
import org.springframework.transaction.annotation.Transactional;

public interface BoardService {
    Board getBoard(Long id);
    Board save(Board board, User user);
    void delete(Long id);
}
