package jjfactory.pet.service.user;

import jjfactory.pet.domain.user.User;
import jjfactory.pet.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    @Override
    public User join(User user) {
//        boolean check = duplicateCheck(user.getUsername());

         User save = userRepository.save(user);

        String rawPassword = save.getPassword();
        String encoded = encoder.encode(rawPassword);
        save.hashingPassword(encoded);
        return save;
    }

    @Override
    public User findByEmail() {
        return null;
    }

    @Override
    public User findById() {
        return null;
    }

    @Override
    public List<User> findByUsername() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public boolean duplicateCheck(String name){
        User user = userRepository.findByUsername(name);
        if(user != null){
            throw  new IllegalArgumentException("중복된 회원입니다");
        }
        return true;
    }
}
