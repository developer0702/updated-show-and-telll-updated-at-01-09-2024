package com.appointment.service;

import com.appointment.openfegin.DoctorOpenFegin;
import com.appointment.openfegin.MedicationOpenFiegn;
import com.appointment.openfegin.PatientOpenFegin;
import com.appointment.response.DoctorResponse;
import com.appointment.response.MedicationResponse;
import com.appointment.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    DoctorOpenFegin doctorFegin;

    @Autowired
    PatientOpenFegin patientFegin;
    @Autowired
    MedicationOpenFiegn medicationOpenFiegn;

    public DoctorResponse getDoctorById(long did) {
        DoctorResponse doctorResponse = doctorFegin.getById(did);
        return doctorResponse;
    }

    public PatientResponse getPatientById(long pid) {
        PatientResponse patientResponse = patientFegin.getById(pid);
        return patientResponse;
    }

    public MedicationResponse getByMedicationId(long medicationId) {
        MedicationResponse medicationResponse = medicationOpenFiegn.getByMedicationId(medicationId);
        return medicationResponse;
    }
}
