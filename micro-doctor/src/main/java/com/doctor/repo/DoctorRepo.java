package com.doctor.repo;

import com.doctor.entity.Doctor;
import com.doctor.response.AppointmentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    public Doctor findByEmail(String email);

}
