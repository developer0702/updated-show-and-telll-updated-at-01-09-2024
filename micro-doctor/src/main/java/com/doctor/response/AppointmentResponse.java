package com.doctor.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AppointmentResponse {

    private long aid;

    private long did;

    private long pid;

    private LocalDate date;

    private LocalTime time;

    private PatientResponse patientResponse;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PatientResponse getPatientResponse() {
        return patientResponse;
    }

    public void setPatientResponse(PatientResponse patientResponse) {
        this.patientResponse = patientResponse;
    }


}
