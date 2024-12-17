package dev.gunho.toooy.appointment.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import dev.gunho.toooy.user.constant.UserRole;
import dev.gunho.toooy.user.dto.UserDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

public class AppointmentPayloads {
    public record createAppointmentRequest(
/*param
1. userId -- 생성자
2. title -- 약속 제목
3. startDate -- 약속일
4. startTime -- 약속 시작
5. memberId -- 모임 멤버 array
6. prankId -- 벌칙 ID -- 벌칙은 선등록될 것이기 때문
*/
        @NotBlank(message = "userId is required")
        String userId,
        @NotBlank(message = "title is required")
        String title,
        @NotBlank(message = "start date is required")
        String startDate,
        @NotBlank(message = "start time is required")
        String startTime,
        @NotNull(message = "member is required")
        ArrayList<UserDto> memberId,
        int prankId

    ) {
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @SuperBuilder(toBuilder = true)
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    public static class AddressV2Info {
        private String fullAddress;
        private String houseNumber;
        private String street;
        private String city;
        private String region;
        private String province;
        private String barangay;
        private String postalCode;
    }

}
