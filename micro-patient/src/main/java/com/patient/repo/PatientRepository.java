package com.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.patient.entity.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	Patient findByEmail(String email);

}
