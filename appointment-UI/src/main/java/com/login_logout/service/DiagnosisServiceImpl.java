package com.login_logout.service;


import com.login_logout.openfegin.DiagnosisFeign;
import com.login_logout.repo.DiagnosisRepository;
import com.login_logout.response.DiagnosisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private DiagnosisFeign diagnosisFeign;

    @Override
    public DiagnosisResponse createDiagnosis(DiagnosisResponse diagnosis) {

        return diagnosisFeign.createDiagnosis(diagnosis);
    }

    @Override
    public DiagnosisResponse getDiagnosisByDiagnosisId(long diagnosisId) {
        return diagnosisFeign.getDiagnosis(diagnosisId);
    }

}
