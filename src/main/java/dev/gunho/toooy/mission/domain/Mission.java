package dev.gunho.toooy.mission.domain;

import dev.gunho.toooy.appointment.domain.Appointment;
import dev.gunho.toooy.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "mission")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx; // 미션 고유 식별자

    @Column(name = "mission_id", nullable = false, unique = true, length = 32)
    private String missionId;

    @Column(nullable = false, length = 500)
    private String description; // 미션 설명

    @Column(nullable = false)
    private boolean isSystemMission; // 시스템 기본 미션 여부 (true: 시스템 미션, false: 사용자 정의 미션)

    @Builder.Default
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MissionCompletion> missionCompletions = new ArrayList<>();;  // 미션을 완료한 사람들

    @OneToOne(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private Appointment appointment; // 연결된 약속 (1:1 관계)
}
