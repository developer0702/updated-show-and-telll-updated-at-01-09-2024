package com.login_logout.request;

import com.login_logout.converter.StringToTimeConverter;
import com.login_logout.response.MedicationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Convert;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {

    private long medicationId;
    private String name;
    private String dose;
    private String route;
    private String frequency;
    private String unitOfMeasure;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @DateTimeFormat(pattern = "HH:mm")
    @Convert(converter = StringToTimeConverter.class)
    private Time time;

    private int duration;

    private long pid;
    private long did;
    private MedicationResponse medicationResponse;

}
