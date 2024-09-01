package com.patient.service;

import com.patient.openfegin.DoctorOpenFegin;
import com.patient.openfegin.MedicationFiegn;
import com.patient.openfegin.appointmentOpenFegin;
import com.patient.request.MedicationRequest;
import com.patient.response.AppointmentResponse;
import com.patient.response.DoctorResponse;
import com.patient.response.MedicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired
    appointmentOpenFegin appointmentFegin;

    @Autowired
    DoctorOpenFegin doctorFegin;

    @Autowired
    MedicationFiegn medicationFiegn;

    public List<AppointmentResponse> PatientAppointment(long pid) {
        List<AppointmentResponse> appointmentResponse = appointmentFegin.getAppsByPid(pid);

        return appointmentResponse;

    }

    public List<DoctorResponse> getAllDoctors() {
        List<DoctorResponse> doctors = doctorFegin.GetAllDoctors();
        return doctors;
    }

    public DoctorResponse getDoctorByDID(long id) {
        return doctorFegin.getById(id);
    }

    public AppointmentResponse CreateAppointment(AppointmentResponse appointmentResponse) {
        return appointmentFegin.CreateAppointment(appointmentResponse);
    }


    public AppointmentResponse GetPaaointmentByAID(long aid) {
        return appointmentFegin.getAppById(aid);
    }

    public boolean DeteleAppointment(long aid) {
        return appointmentFegin.DeleteAppoointment(aid);
    }

    public boolean ChangeStatus(long aid, int st) {
        appointmentFegin.ChangeStatus(aid, st);
        return true;
    }
}
