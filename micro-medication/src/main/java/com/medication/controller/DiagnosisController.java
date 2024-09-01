package com.medication.controller;

import com.medication.entity.Diagnosis;
import com.medication.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnoses")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping("/getAllDiagnosis")
    public ResponseEntity<List<Diagnosis>> getAllDiagnoses() {
        List<Diagnosis> diagnoses = diagnosisService.getAllDiagnoses();
        return new ResponseEntity<>(diagnoses, HttpStatus.OK);
    }

    @PostMapping("/createDiagnosis")
    public ResponseEntity<Diagnosis> createDiagnosis(@RequestBody Diagnosis diagnosis) {
        Diagnosis createdDiagnosis = diagnosisService.createDiagnosis(diagnosis);
        return new ResponseEntity<>(createdDiagnosis, HttpStatus.CREATED);
    }

    @GetMapping("/getDiagnosis/{id}")
    public ResponseEntity<Diagnosis> getDiagnosis(@PathVariable long id) {
        Diagnosis diagnosis = diagnosisService.getDiagnosis(id);
        return new ResponseEntity<>(diagnosis, HttpStatus.OK);
    }

    @PutMapping("/editDiagnosis/{id}")
    public ResponseEntity<Diagnosis> editDiagnosis(@PathVariable long id, @RequestBody Diagnosis diagnosis) {
        Diagnosis updatedDiagnosis = diagnosisService.editDiagnosis(diagnosis, id);
        return new ResponseEntity<>(updatedDiagnosis, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDiagnosis/{id}")
    public ResponseEntity<String> deleteDiagnosis(@PathVariable long id) {
        diagnosisService.deleteDiagnosis(id);
        return new ResponseEntity<>("Diagnosis deleted successfully", HttpStatus.OK);
    }

}
