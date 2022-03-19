package jjfactory.pet.controller;

import jjfactory.pet.config.auth.UserDetailsImpl;
import jjfactory.pet.domain.board.Board;
import jjfactory.pet.domain.user.User;
import jjfactory.pet.dto.BoardReq;
import jjfactory.pet.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("/board")
    public String boardForm(){
        return "board/boardForm";
    }

    @PostMapping("/board")
    public String createBoard(BoardReq boardReq, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Board board = boardReq.toEntity();
        User session = userDetails.getUser();
        board.setSessionId(session);
        boardService.save(board);
        return "redirect:/";
    }

    @DeleteMapping("/board")
    public String createBoard(Long id){
        boardService.delete(id);
        return "redirect:/";
    }
}
