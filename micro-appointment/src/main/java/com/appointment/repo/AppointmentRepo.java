package com.appointment.repo;

import com.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    List<Appointment> getByDid(long did);

    List<Appointment> getByPid(long pid);

}
