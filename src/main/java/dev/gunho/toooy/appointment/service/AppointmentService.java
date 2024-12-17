package dev.gunho.toooy.appointment.service;

import dev.gunho.toooy.appointment.repository.AppointmentRepository;
import dev.gunho.toooy.global.dto.ApiResponseCode;
import dev.gunho.toooy.global.exception.TooyException;
import dev.gunho.toooy.user.domain.User;
import dev.gunho.toooy.user.dto.ResultStatus;
import dev.gunho.toooy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;



}
