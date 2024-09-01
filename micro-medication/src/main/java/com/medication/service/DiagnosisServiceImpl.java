package com.medication.service;

import com.medication.entity.Diagnosis;
import com.medication.exception.ResourceNotFoundException;
import com.medication.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisRepository.findAll();
    }

    @Override
    public Diagnosis createDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis getDiagnosis(long diagnosisId) {
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId).orElseThrow(() -> new ResourceNotFoundException("Diagnosis", "diagnosisId", diagnosisId));

        return diagnosis;
    }

    @Override
    public Diagnosis editDiagnosis(Diagnosis diagnosis, long diagnosisId) {
        Diagnosis updateDiagnosis = diagnosisRepository.findById(diagnosisId).orElseThrow(() -> new ResourceNotFoundException("Diagnosis", "diagnosisId", diagnosisId));
        updateDiagnosis.setCategory(diagnosis.getCategory());
        updateDiagnosis.setNote(diagnosis.getNote());
        updateDiagnosis.setEvidence(diagnosis.getEvidence());
        updateDiagnosis.setBodySite(diagnosis.getBodySite());
        updateDiagnosis.setConditionCodes(diagnosis.getConditionCodes());
        updateDiagnosis.setStatus(diagnosis.getStatus());
        updateDiagnosis.setOnset(diagnosis.getOnset());
        updateDiagnosis.setSeverity(diagnosis.getSeverity());
        return updateDiagnosis;
    }

    @Override
    public void deleteDiagnosis(long id) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Diagnosis", "diagnosisId", id));
        diagnosisRepository.delete(diagnosis);
    }

}