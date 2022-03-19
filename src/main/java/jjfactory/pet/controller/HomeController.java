package jjfactory.pet.controller;

import jjfactory.pet.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final BoardServiceImpl boardService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("boards",boardService.getBoardList());
        return "home";
    }
}
