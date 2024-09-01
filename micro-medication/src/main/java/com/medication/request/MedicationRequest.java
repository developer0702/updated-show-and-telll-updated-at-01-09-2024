package com.medication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {

    private String name;
    private String dose;
    private String route;
    private String frequency;
    private String unitOfMeasure;
    private Date startDate;
    private Date endDate;
    private Time time;
    private int duration;
}
