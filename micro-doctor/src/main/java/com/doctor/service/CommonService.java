package com.doctor.service;

import com.doctor.openfeign.AppointmentOpenFegin;
import com.doctor.response.AppointmentResponse;
import com.doctor.response.MedicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired
    AppointmentOpenFegin appointmentFegin;


    public List<AppointmentResponse> DoctorAppointment(long did) {
        List<AppointmentResponse> appointmentResponse = appointmentFegin.getAppsByDid(did);
        return appointmentResponse;
    }

    public boolean ChangeStatus(long aid, int st) {
        appointmentFegin.ChangeStatus(aid, st);
        return true;
    }

    public AppointmentResponse updateAppointmentByDoctor(AppointmentResponse appointmentResponse) {
        return appointmentFegin.CreateAppointment(appointmentResponse);
    }

    public  List<MedicationResponse> getAllMedicationsByDid(long did){
        return appointmentFegin.getAllMedicationsByDid(did);
    }

    public AppointmentResponse GetPaaointmentByAID(long aid) {
        return appointmentFegin.getAppById(aid);
    }
}
