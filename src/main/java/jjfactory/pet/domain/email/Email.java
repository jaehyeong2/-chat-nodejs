package jjfactory.pet.domain.email;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Email {

    @Id
    @GeneratedValue
    @Column(name = "email_id")
    private Long id;

    private String email;
    private String title;
    private String message;

}
