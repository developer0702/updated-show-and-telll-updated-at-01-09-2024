package com.login_logout.repo;

import com.login_logout.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis,Long> {
}
