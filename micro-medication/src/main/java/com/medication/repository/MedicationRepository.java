package com.medication.repository;

import com.medication.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByPid(long pid);

    // Create method findByDid
    List<Medication> findByDid(long did);

}
