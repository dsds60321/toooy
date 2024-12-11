package dev.gunho.toooy.appointment.entity;

import dev.gunho.toooy.appointment.constant.Status;
import dev.gunho.toooy.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "appointments")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointments extends BaseTimeEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(length = 255)
    private String penalty; // 벌칙 (예: "사람들에게 커피 사기")

    @Column(name = "win_condition", length = 255)
    private String winCondition; // 승리 조건

    // N:N 관계를 UserAppointment 테이블로 중계
    @Builder.Default
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAppointment> userAppointments = new ArrayList<>();

}
