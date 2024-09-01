package com.patient.controller;


import com.patient.entity.Patient;
import com.patient.request.MedicationRequest;
import com.patient.response.AppointmentResponse;
import com.patient.response.DoctorResponse;
import com.patient.response.PatientResponse;
import com.patient.service.CommonService;
import com.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    CommonService commonService;

    @GetMapping("/getById/{id}")
    //@CrossOrigin("http://localhost:8081")
    public ResponseEntity<Object> getById(@PathVariable long id) {

        return new ResponseEntity<>(new PatientResponse(patientService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("/register")
    public PatientResponse createuser(@RequestBody Patient patient) {
        Patient newPatient = patientService.createUser(patient);
        PatientResponse patientResponse = new PatientResponse(newPatient);
        return patientResponse;

    }

    @PutMapping("/update/{id}")
    public PatientResponse Updatepatient(@RequestBody Patient patient, @PathVariable long id) {
        patient.setId(id);

        Patient patientNew = patientService.UpdatePatient(patient);

        PatientResponse patientResponse = new PatientResponse(patientNew);

        return patientResponse;

    }

    @DeleteMapping("/delete/{id}")
    public boolean DeletePatient(@PathVariable long id) {
        return patientService.DeletePatient(id);
    }

    @GetMapping("/getByEmail/{email}")
    public PatientResponse getByEmail(@PathVariable String email) {
        return patientService.getByEmail(email);
    }

    @GetMapping("/Apps/{pid}")
    public List<AppointmentResponse> myAppos(@PathVariable long pid) {

        return commonService.PatientAppointment(pid);
    }

    @GetMapping("/AppByAid/{aid}")
    public AppointmentResponse getAppointmentByAID(@PathVariable long aid) {
        AppointmentResponse appointment = commonService.GetPaaointmentByAID(aid);
        System.out.println(appointment.toString());
        return appointment;
    }

    @GetMapping("/doctors")
    public List<DoctorResponse> getAllDoctors() {
        return commonService.getAllDoctors();
    }

    @GetMapping("/book/{did}")
    public DoctorResponse GetDoctorByDid(@PathVariable long did) {
        return commonService.getDoctorByDID(did);
    }

    @PostMapping("/book")
    public AppointmentResponse CreateAppointment(@RequestBody AppointmentResponse appointmentResponse) {
        return commonService.CreateAppointment(appointmentResponse);
    }


    @DeleteMapping("/deleteAppointemt/{aid}")
    public boolean DeleteAppointment(@PathVariable long aid) {
        return commonService.DeteleAppointment(aid);
    }

    @GetMapping("/status/{aid}/{st}")
    public boolean ChangeStatus(@PathVariable long aid, @PathVariable int st) {
        commonService.ChangeStatus(aid, st);
        return true;
    }
}
