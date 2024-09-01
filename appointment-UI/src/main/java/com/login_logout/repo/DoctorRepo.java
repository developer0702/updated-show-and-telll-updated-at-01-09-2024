package com.login_logout.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login_logout.entity.Doctor;


public interface DoctorRepo extends JpaRepository<Doctor, Long> {
	
	public boolean existsByEmail(String email);

	public Doctor findByEmail(String email);

}
