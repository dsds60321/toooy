package dev.gunho.toooy.appointment.entity;

import dev.gunho.toooy.appointment.constant.Status;
import dev.gunho.toooy.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "user_appointment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", nullable = false)
    private User user; // 연결된 유저

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_idx", nullable = false)
    private Appointments appointment; // 연결된 약속

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private Status status; // 참여 상태

    @Column(name = "is_host", nullable = false)
    private Boolean isHost; // 주최자 여부 user 기준

    @Column(name = "result_status")
    private Boolean resultStatus;
}
