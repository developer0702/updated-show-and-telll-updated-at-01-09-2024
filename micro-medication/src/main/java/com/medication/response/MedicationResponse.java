package com.medication.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private long duration;
    private long aid;
    private long pid;

}