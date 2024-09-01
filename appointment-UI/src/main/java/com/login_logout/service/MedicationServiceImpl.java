package com.login_logout.service;

import com.login_logout.openfegin.MedicationFiegn;
import com.login_logout.response.MedicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    MedicationFiegn medicationFiegn;

    @Override
    public MedicationResponse createMedicine(MedicationResponse medication) {
        return medicationFiegn.createMedication(medication);
    }

    @Override
    public MedicationResponse getMedicationByMedicationId(long medicationId) {
        return medicationFiegn.getByMedicationId(medicationId);
    }

    @Override
    public MedicationResponse updateMedication( MedicationResponse medication,long medicationId) {
        return medicationFiegn.updateMedication(medication,medicationId);
    }

    @Override
    public boolean deleteMedication(long medicationId) {
        return medicationFiegn.deleteMedication(medicationId);
    }

    @Override
    public List<MedicationResponse> getAllMedications() {
        return medicationFiegn.getAllMedications();
    }

    @Override
    public List<MedicationResponse> getAllMedicationsByDid(long did) {
        return medicationFiegn.getAllMedicationsByDid(did);
    }

    @Override
    public List<MedicationResponse> getAllMedicationsByPid(long pid) {
        return medicationFiegn.getAllMedicationsByPid(pid);
    }
}