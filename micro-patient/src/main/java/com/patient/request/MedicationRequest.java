package com.patient.request;

import com.patient.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

//    @ManyToOne
//    @JoinColumn(name = "pid")
//    private Patient patient;
}
