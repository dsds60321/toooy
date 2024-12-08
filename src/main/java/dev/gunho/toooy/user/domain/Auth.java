package dev.gunho.toooy.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.gunho.toooy.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Description("user JWT token 테이블")
@Entity(name = "auth")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth extends BaseTimeEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(nullable = false)
    private String accessToken;

    @Column(nullable = false)
    private String refreshToken;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "udt_date")
    private LocalDateTime udtDate;
}
