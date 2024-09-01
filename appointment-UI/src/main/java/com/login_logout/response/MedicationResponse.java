package com.login_logout.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationResponse {

    private long medicationId;
    private String name;
    private String dose;
    private String route;
    private String frequency;
    private String unitOfMeasure;
    private Time time;
    private Date startDate;
    private Date endDate;

    private long appointmentId;
    private long pid;
    private long did;
    private long duration;

    private PatientResponse patient;

    private MedicationResponse medicationResponse;

    @Override
    public String toString() {
        return "MedicationResponse{" +
                "medicationId=" + medicationId +
                ", name='" + name + '\'' +
                ", dose='" + dose + '\'' +
                ", route='" + route + '\'' +
                ", frequency='" + frequency + '\'' +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", time=" + time +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", appointmentId=" + appointmentId +
                ", pid=" + pid +
                ", duration=" + duration +
                ", patient=" + patient +
                ", medicationResponse=" + medicationResponse +
                '}';
    }
}