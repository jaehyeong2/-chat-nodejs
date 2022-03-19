package jjfactory.pet.controller;

import jjfactory.pet.domain.user.Role;
import jjfactory.pet.domain.user.User;
import jjfactory.pet.dto.JoinReq;
import jjfactory.pet.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/signup")
    public String signupForm(){
        return "user/signup";
    }

    @GetMapping("/signin")
    public String signinForm(){
        return "user/signin";
    }

    @PostMapping("/signup")
    public String signup(JoinReq joinReq){
        User user = joinReq.toEntity();
        user.changeRole(Role.USER);
        userServiceImpl.join(user);
        log.info("USER CONTROLLER 호출: 회원가입");
        return "redirect:/";
    }
}
