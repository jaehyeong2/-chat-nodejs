package jjfactory.pet.controller;

import jjfactory.pet.domain.comment.Comment;
import jjfactory.pet.dto.CommentReq;
import jjfactory.pet.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<?> save(@RequestBody CommentReq commentReq){
        Comment comment = commentReq.toEntity();
        commentService.save(comment);
        return new ResponseEntity<>("생성 완료", HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> save(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }
}
