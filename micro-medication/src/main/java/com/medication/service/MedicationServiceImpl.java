package com.medication.service;

import com.medication.entity.Medication;
import com.medication.exception.ResourceNotFoundException;
import com.medication.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;


    @Override
    public Medication createMedicine(Medication medication) {
        Medication savedMedication = medicationRepository.save(medication);
        return savedMedication;
    }

    @Override
    public List<Medication> getAllMedication() {
        List<Medication> medications = medicationRepository.findAll();
        return medications;
    }

    @Override
    public boolean deleteMedication(long medicationId) {
        Medication medication = medicationRepository.findById(medicationId).orElseThrow(() -> new ResourceNotFoundException("Medication", "medicationId", medicationId));
        medicationRepository.delete(medication);
        return true;
    }

    @Override
    public Medication getMedication(long medicationId) {
        Medication medication = medicationRepository.findById(medicationId).orElseThrow(() -> new ResourceNotFoundException("Medication", "medicationId", medicationId));
        return medication;
    }

    @Override
    public Medication updateMedication(Medication medication, long medicationId) {
        Medication existingMedication = medicationRepository.findById(medicationId).orElseThrow(() -> new ResourceNotFoundException("Medication", "medicationId", medicationId));
        existingMedication.setDose(medication.getDose());
        existingMedication.setName(medication.getName());
        existingMedication.setRoute(medication.getRoute());
        existingMedication.setStartDate(medication.getStartDate());
        existingMedication.setFrequency(medication.getFrequency());
        existingMedication.setUnitOfMeasure(medication.getUnitOfMeasure());
        Medication updatedMedication = medicationRepository.save(existingMedication);
        return updatedMedication;
    }

    @Override
    public List<Medication> getAllMedicationsByPid(long pid) {
        List<Medication> medications = medicationRepository.findByPid(pid);
        return medications;
    }

    @Override
    public List<Medication> getAllMedicationsByDid(long did) {
        List<Medication> medications = medicationRepository.findByDid(did);
        return medications;
    }
}