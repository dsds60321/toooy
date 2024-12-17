package dev.gunho.toooy.appointment.repository;

import dev.gunho.toooy.appointment.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
