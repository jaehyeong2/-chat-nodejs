package jjfactory.pet.dto;

import jjfactory.pet.domain.comment.Comment;
import lombok.Data;

@Data
public class CommentReq {
    String content;

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .build();
    }
}
