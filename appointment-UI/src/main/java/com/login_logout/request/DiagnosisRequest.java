package com.login_logout.request;

import com.login_logout.response.DiagnosisResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisRequest {

    private String conditionCodes;
    private String status;
    private String category;
    private String severity;
    private String bodySite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date onset;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date abatement;
    private String stage;
    private String evidence;
    private String note;
    private long did;
    private long pid;

    private DiagnosisResponse diagnosisResponse;
}
