package com.appointment.response;

import com.appointment.entity.Appointment;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;


public class AppointmentResponse {
    private long aid;

    private long did;

    private long pid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;
    private String status;
    private DoctorResponse doctorResponse;
    private PatientResponse patientResponse;

    public AppointmentResponse(Appointment appointment) {

        this.aid = appointment.getAid();
        this.did = appointment.getDid();
        this.pid = appointment.getPid();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
        this.status = appointment.getStatus();

    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public DoctorResponse getDoctorResponse() {
        return doctorResponse;
    }


    public void setDoctorResponse(DoctorResponse doctorResponse) {
        this.doctorResponse = doctorResponse;
    }


    public PatientResponse getPatientResponse() {
        return patientResponse;
    }


    public void setPatientResponse(PatientResponse patientResponse) {
        this.patientResponse = patientResponse;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


}

