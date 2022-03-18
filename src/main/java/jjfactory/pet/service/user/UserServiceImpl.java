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
        User save = userRepository.save(user);

        //비밀번호 해싱
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
}
