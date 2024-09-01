package com.medication.service;

import com.medication.entity.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    List<Diagnosis> getAllDiagnoses();

    Diagnosis createDiagnosis(Diagnosis diagnosis);

    Diagnosis getDiagnosis(long diagnosisId);

    Diagnosis editDiagnosis(Diagnosis diagnosis, long diagnosisId);

    void deleteDiagnosis(long id);
}
