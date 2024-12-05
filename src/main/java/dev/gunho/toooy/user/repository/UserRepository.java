package dev.gunho.toooy.user.repository;

import dev.gunho.toooy.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
