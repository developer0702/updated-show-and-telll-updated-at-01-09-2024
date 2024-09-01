package com.login_logout.response;

import com.login_logout.openfegin.DiagnosisFeign;
import com.login_logout.request.DiagnosisRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisResponse {


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

    private DiagnosisRequest  diagnosisRequest;

    @Override
    public String toString() {
        return "DiagnosisResponse{" +
                "conditionCodes='" + conditionCodes + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", severity='" + severity + '\'' +
                ", bodySite='" + bodySite + '\'' +
                ", onset=" + onset +
                ", abatement=" + abatement +
                ", stage='" + stage + '\'' +
                ", evidence='" + evidence + '\'' +
                ", note='" + note + '\'' +
                ", did=" + did +
                ", pid=" + pid +
                ", diagnosisRequest=" + diagnosisRequest +
                '}';
    }
}
