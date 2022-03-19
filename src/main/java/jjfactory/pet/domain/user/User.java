package jjfactory.pet.domain.user;

import jjfactory.pet.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User extends BaseTimeEntity {

    @Id @Column(name = "user_id")
    @GeneratedValue
    private Long id;

    private String username;
    private String name;
    private String email;
    private String password;

    public User(Long id, String username, String name, String email, String password, Address address, Role role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void changeRole(Role role){
        this.role = role;
    }

    public void hashingPassword(String password){
        this.password = password;
    }
}
