package com.medication.repository;


import com.medication.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis,Long> {

}
