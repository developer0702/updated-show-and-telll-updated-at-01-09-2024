package com.login_logout.controller;

import com.login_logout.response.DiagnosisResponse;
import com.login_logout.response.MedicationResponse;
import com.login_logout.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diagnosis")
public class DiagnosisController {

    @Autowired
    DiagnosisService diagnosisService;
    @PostMapping("/create")
    public DiagnosisResponse createMedication(@ModelAttribute DiagnosisResponse medication) {
        diagnosisService.createDiagnosis(medication);
        return medication;
    }
}
