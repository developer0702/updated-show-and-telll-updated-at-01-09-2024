package com.medication.controller;

import com.medication.entity.Medication;
import com.medication.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @PostMapping("/create")
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) {
        Medication createdMedication = medicationService.createMedicine(medication);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }

    @GetMapping("/getAllMedications")
    public ResponseEntity<List<Medication>> getAllMedications() {
        List<Medication> medications = medicationService.getAllMedication();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/getMedication/{medicationId}")
    public ResponseEntity<Medication> getMedication(@PathVariable long medicationId) {
        Medication medication = medicationService.getMedication(medicationId);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }

    @PutMapping("/updateMedication/{medicationId}")
    public ResponseEntity<Medication> updateMedication(@PathVariable long medicationId, @RequestBody Medication medication) {
        Medication updatedMedication = medicationService.updateMedication(medication, medicationId);
        return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMedication/{medicationId}")
    public ResponseEntity<Void> deleteMedication(@PathVariable long medicationId) {
        medicationService.deleteMedication(medicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllMedicationsByPid/{pid}")
    public ResponseEntity<List<Medication>> getAllMedicationsByPid(@PathVariable long pid) {
        List<Medication> medications = medicationService.getAllMedicationsByPid(pid);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/getAllMedicationsByDid/{did}")
    public ResponseEntity<List<Medication>> getAllMedicationsByDid(@PathVariable long did) {
        List<Medication> medications = medicationService.getAllMedicationsByDid(did);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }
}