package dev.gunho.toooy.user.entity;

import dev.gunho.toooy.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseTimeEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(name = "user_id", nullable = false, unique = true, length = 32)
    private String userId;

    @Column(nullable = false, length = 32)
    private String password;

    @Column(unique = true, length = 64)
    private String email;

    @Column(length = 32)
    private String nick;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "udt_date")
    private LocalDateTime udtDate;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idx == that.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idx);
    }
}
