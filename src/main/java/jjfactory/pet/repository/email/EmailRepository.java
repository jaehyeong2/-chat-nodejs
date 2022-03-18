package jjfactory.pet.repository.email;

import jjfactory.pet.domain.email.Email;
import jjfactory.pet.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,Long> {
}
