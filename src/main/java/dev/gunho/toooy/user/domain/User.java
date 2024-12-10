package dev.gunho.toooy.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.gunho.toooy.global.entity.BaseTimeEntity;
import dev.gunho.toooy.user.constant.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(name = "user_id", nullable = false, unique = true, length = 32)
    private String userId;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(length = 64)
    private String email;

    @Column(length = 32)
    private String nick;

    @Column(length = 4)
    private String os;

    @Column(length = 128)
    private String uuid;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "udt_date")
    private LocalDateTime udtDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Auth auth;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return idx == that.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idx);
    }
}
