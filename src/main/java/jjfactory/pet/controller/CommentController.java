package jjfactory.pet.controller;

import jjfactory.pet.config.auth.UserDetailsImpl;
import jjfactory.pet.domain.comment.Comment;
import jjfactory.pet.domain.user.User;
import jjfactory.pet.dto.CommentReq;
import jjfactory.pet.dto.CommonRes;
import jjfactory.pet.service.comment.CommentService;
import jjfactory.pet.service.comment.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentServiceImpl commentService;

    @PostMapping("/board/{boardId}/comment")
    public CommonRes<?> save(@RequestBody CommentReq commentReq, @AuthenticationPrincipal UserDetailsImpl userDetails,
                             @PathVariable Long boardId){
        Comment comment = commentReq.toEntity();
        commentService.save(comment,userDetails.getUser(),boardId);
        return new CommonRes<>(HttpStatus.OK.value(),comment);
    }

    @DeleteMapping("/comment/{id}")
    public CommonRes<?> delete(@PathVariable Long id){
        commentService.delete(id);
        return new CommonRes<>(HttpStatus.OK.value(),"삭제완료");
    }
}
