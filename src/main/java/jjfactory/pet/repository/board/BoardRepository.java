package jjfactory.pet.repository.board;

import jjfactory.pet.domain.board.Board;
import jjfactory.pet.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
