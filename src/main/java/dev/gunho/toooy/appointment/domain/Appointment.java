package dev.gunho.toooy.appointment.domain;

import dev.gunho.toooy.global.entity.BaseTimeEntity;
import dev.gunho.toooy.mission.domain.Mission;
import dev.gunho.toooy.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity(name = "appointments")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx; // 약속 고유 식별자

    @Column(name = "appointment_id", nullable = false, unique = true, length = 32)
    private String appointmentId;

    @Column(nullable = false, length = 100)
    private String title; // 약속 제목

    @Column(length = 500)
    private String description; // 약속 설명 (선택 사항)

    @Column(nullable = false)
    private LocalDateTime startDate; // 약속 시작 날짜 및 시간

    @Builder.Default
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAppointment> userAppointments = new ArrayList<>();; // 약속에 참여하는 사용자 리스트 (중간 테이블)

    @OneToOne
    @JoinColumn(name = "mission_id", nullable = true)
    private Mission mission; // 약속에 연결된 미션 (1:1 관계)

    // 주최자(User) 가져오기
    public Optional<User> getHost() {
        return userAppointments.stream()
                .filter(UserAppointment::getIsHost) // 주최자 여부가 true인 경우
                .map(UserAppointment::getUser) // 주최자 User 반환
                .findFirst();
    }

    // 참여 유저 리스트 반환
    public List<User> getParticipants() {
        return userAppointments.stream()
                .map(UserAppointment::getUser) // 각 UserAppointment에서 User를 추출
                .toList(); // 리스트로 반환
    }

    // 특정 유저가 이 약속에 포함되었는지 확인
    public boolean isUserIncluded(User user) {
        return userAppointments.stream()
                .anyMatch(ua -> ua.getUser().equals(user)); // 유저 포함 여부 반환
    }

}
