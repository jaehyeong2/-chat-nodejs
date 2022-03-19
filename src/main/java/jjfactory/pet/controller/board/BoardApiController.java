package jjfactory.pet.controller.board;

import jjfactory.pet.config.auth.UserDetailsImpl;
import jjfactory.pet.domain.board.Board;
import jjfactory.pet.domain.user.User;
import jjfactory.pet.dto.BoardReq;
import jjfactory.pet.dto.CommonRes;
import jjfactory.pet.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardServiceImpl boardService;

    @PostMapping("/board")
    public CommonRes<?> createBoard(@RequestBody BoardReq boardReq, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Board board = boardReq.toEntity();
        boardService.save(board,userDetails.getUser());
        return new CommonRes<>(HttpStatus.OK.value(),board);
    }

    @DeleteMapping("/board/{id}")
    public CommonRes<?> deleteBoard(@PathVariable Long id){
        boardService.delete(id);
        return new CommonRes<>(HttpStatus.OK.value(),null);
    }
}
