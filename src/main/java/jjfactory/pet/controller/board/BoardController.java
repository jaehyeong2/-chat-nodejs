package jjfactory.pet.controller.board;

import jjfactory.pet.config.auth.UserDetailsImpl;
import jjfactory.pet.domain.board.Board;
import jjfactory.pet.domain.user.User;
import jjfactory.pet.dto.BoardReq;
import jjfactory.pet.service.board.BoardServiceImpl;
import jjfactory.pet.service.comment.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;
    private final CommentServiceImpl commentService;

    @GetMapping("/board")
    public String boardForm(){
        return "board/boardForm";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable Long id, Model model,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("board",boardService.getBoard(id));
        model.addAttribute("principal",userDetails.getUser());
        model.addAttribute("comments",commentService.getCommentList());
        return "board/boardDetailForm";
    }
}
