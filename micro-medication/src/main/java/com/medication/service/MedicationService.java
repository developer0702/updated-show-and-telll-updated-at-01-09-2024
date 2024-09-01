package com.medication.service;

import com.medication.entity.Medication;
import com.medication.response.MedicationResponse;

import java.util.List;

public interface MedicationService  {

    Medication createMedicine(Medication medication);
    List<Medication> getAllMedication();
    boolean deleteMedication(long medicationId);
    Medication getMedication(long medicationId);
    Medication updateMedication(Medication medication,long medicationId);

    List<Medication> getAllMedicationsByPid(long pid);
    List<Medication> getAllMedicationsByDid(long did);
}