package jjfactory.pet.dto;

import jjfactory.pet.domain.board.Board;
import lombok.Data;

@Data
public class BoardReq {
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
