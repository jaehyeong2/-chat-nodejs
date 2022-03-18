package jjfactory.pet.dto;

import jjfactory.pet.domain.user.User;
import lombok.Data;

@Data
public class JoinReq {

    private String username;
    private String name;
    private String email;
    private String password;

    public User toEntity(){
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
