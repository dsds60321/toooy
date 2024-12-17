package dev.gunho.toooy.appointment.controller;

import dev.gunho.toooy.appointment.dto.AppointmentPayloads;
import dev.gunho.toooy.appointment.service.AppointmentService;
import dev.gunho.toooy.user.dto.UserDto;
import dev.gunho.toooy.user.service.AuthService;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Description("약속")
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
//TODO LIST
// 1.약속 생성 /
// 2.약속 코드 생성  /code
// 3.약속 코드 전송 /{appointmentId}/code/send


    private final AppointmentService appointmentService;

    @PostMapping
    public String createAppointment(@RequestBody AppointmentPayloads.createAppointmentRequest createAppointmentRequest) {

        return "";
    }
}
