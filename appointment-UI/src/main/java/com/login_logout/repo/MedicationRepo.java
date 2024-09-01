package com.login_logout.repo;

import com.login_logout.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepo extends JpaRepository<Medication,Long> {


}
