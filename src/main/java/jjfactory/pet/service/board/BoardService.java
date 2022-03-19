package jjfactory.pet.service.board;

import jjfactory.pet.domain.board.Board;

public interface BoardService {
    Board getBoard(Long id);
    void save(Board board);
    void delete(Long id);
}
