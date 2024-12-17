package dev.gunho.toooy.mission.domain;

import dev.gunho.toooy.appointment.domain.Appointment;
import dev.gunho.toooy.global.entity.BaseTimeEntity;
import dev.gunho.toooy.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "mission_completion")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionCompletion extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;  // 완료한 미션


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 미션을 완료한 유저


    private LocalDateTime completionTime;  // 미션 완료 시간

    private boolean isCompleted;  // 미션 완료 여부

}
