package com.medication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication")

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicationId;
    private String name;
    private String dose;
    private String route;
    private String frequency;
    private String unitOfMeasure;
    private Date startDate;
    private Date endDate;

    private Time time;
    private long pid;
    private long did;

}

