package dev.gunho.toooy.user.repository;

import dev.gunho.toooy.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUserId(String userId);

    boolean existsByUserId(String userId);
}
