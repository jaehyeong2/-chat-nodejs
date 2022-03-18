package jjfactory.pet.service.user;

import jjfactory.pet.domain.user.User;

import java.util.List;

public interface UserService {

    User join(User user);
    User findByEmail();
    User findById();
    List<User> findByUsername();
    List<User> findAll();
}
