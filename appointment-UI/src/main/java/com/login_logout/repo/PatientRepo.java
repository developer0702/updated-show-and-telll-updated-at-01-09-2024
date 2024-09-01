package com.login_logout.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.login_logout.entity.Patient;


public interface PatientRepo extends JpaRepository<Patient, Long>{

	public boolean existsByEmail(String email);

	public Patient findByEmail(String email);
}
