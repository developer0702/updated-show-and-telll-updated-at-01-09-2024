package com.patient.response;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponse {

    private long aid;


    private long did;


    private long pid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    private DoctorResponse doctorResponse;
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

    public DoctorResponse getDoctorResponse() {
        return doctorResponse;
    }

    public void setDoctorResponse(DoctorResponse doctorResponse) {
        this.doctorResponse = doctorResponse;
    }

}
