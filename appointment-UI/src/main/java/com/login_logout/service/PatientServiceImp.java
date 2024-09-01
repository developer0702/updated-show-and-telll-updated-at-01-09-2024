package com.login_logout.service;

import com.login_logout.openfegin.MedicationFiegn;
import com.login_logout.openfegin.PatientOpenFegin;
import com.login_logout.repo.PatientRepo;
import com.login_logout.response.AppointmentResponse;
import com.login_logout.response.DoctorResponse;
import com.login_logout.response.MedicationResponse;
import com.login_logout.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepo userRepo;

    @Autowired
    PatientOpenFegin patientFegin;
    @Autowired
    MedicationFiegn medicationOpenFeign;

    @Override
    public PatientResponse createUser(PatientResponse patient) {

        return patientFegin.createuser(patient);
    }

    @Override
    public boolean checkEmail(String email) {

        return userRepo.existsByEmail(email);
    }

    @Override
    public PatientResponse getByEmail(String email) {

        return patientFegin.getByEmail(email);
    }

    @Override
    public List<AppointmentResponse> getAllAppointmentsByPid(long pid) {

        List<AppointmentResponse> appointmentResponseList = patientFegin.myAppos(pid);
        return appointmentResponseList;
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {

        return patientFegin.getAllDoctors();
    }

    @Override
    public PatientResponse getById(long id) {

        PatientResponse patientResponse = patientFegin.getById(id);

        return patientResponse;
    }

    @Override
    public PatientResponse updatePatient(PatientResponse patient, long id) {
        // TODO Auto-generated method stub

        return patientFegin.Updatepatient(patient, id);
    }

    @Override
    public DoctorResponse getDoctorByDID(long did) {
        // TODO Auto-generated method stub
        return patientFegin.GetDoctorByDid(did);
    }

    @Override
    public AppointmentResponse CreateAppointment(AppointmentResponse appointmentResponse) {

        return patientFegin.CreateAppointment(appointmentResponse);
    }

    @Override
    public AppointmentResponse getAppointmentByAID(long aid) {

        return patientFegin.getAppointmentByAID(aid);
    }

    @Override
    public boolean DeleteAppointment(long aid) {

        return patientFegin.DeleteAppointment(aid);
    }

    @Override
    public boolean DeletePatient(long id) {

        patientFegin.DeletePatient(id);
        return false;
    }

    @Override
    public boolean UpdateAppoStatus(long aid, int st) {
        // TODO Auto-generated method stub
        patientFegin.ChangeStatus(aid, st);
        return true;
    }
}
