package com.doctor.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MedicationResponse {
    private long medicationId;
    private String name;
    private String dose;
    private String route;
    private String frequency;
    private String unitOfMeasure;
    private Date startDate;
    private Date endDate;

    private long aid;
    private long pid;
    private long duration;
}