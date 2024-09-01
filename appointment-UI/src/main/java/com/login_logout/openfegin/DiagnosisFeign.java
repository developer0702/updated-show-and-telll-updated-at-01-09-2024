package com.login_logout.openfegin;

import com.login_logout.entity.Diagnosis;
import com.login_logout.response.DiagnosisResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "api-gateway")
public interface DiagnosisFeign {

    @GetMapping("micro-medication/diagnoses/getAllDiagnosis")
    List<Diagnosis> getAllDiagnoses();

    @PostMapping("micro-medication/diagnoses/createDiagnosis")
    DiagnosisResponse createDiagnosis(@RequestBody DiagnosisResponse DiagnosisResponse);

    @GetMapping("micro-medication/diagnoses/getDiagnosis/{id}")
    DiagnosisResponse getDiagnosis(@PathVariable long id);

    @PutMapping("micro-medication/diagnoses/editDiagnosis/{id}")
    DiagnosisResponse editDiagnosis(@PathVariable long id, @RequestBody DiagnosisResponse diagnosisResponse);

    @DeleteMapping("micro-medication/diagnoses/deleteDiagnosis/{id}")
    void deleteDiagnosis(@PathVariable long id);
}