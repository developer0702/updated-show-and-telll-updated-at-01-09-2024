package com.login_logout.service;


import com.login_logout.response.DiagnosisResponse;

import java.util.List;

public interface DiagnosisService {

    DiagnosisResponse createDiagnosis(DiagnosisResponse diagnosis);

    DiagnosisResponse getDiagnosisByDiagnosisId(long diagnosisId);

//    List<DiagnosisResponse> getAllDiagnoses();
}
