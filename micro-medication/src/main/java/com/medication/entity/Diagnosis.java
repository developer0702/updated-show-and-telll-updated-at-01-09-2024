package com.medication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long diagnosisId;
    private long did;
    private long id;
    private String conditionCodes;
    private String status;
    private String category;
    private String severity;
    private String bodySite;
    private LocalDate onset;
    private LocalDate abatement;
    private String stage;
    private String evidence;
    private String note;

}
