package com.patient.openfegin;

import com.patient.request.MedicationRequest;
import com.patient.response.MedicationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "micro-medication")
public interface MedicationFiegn {

    @GetMapping("medication/getMedication/{medicationId}")
    public MedicationResponse getByMedicationId(@PathVariable long medicationId);

    @GetMapping("medication/getAllMedications")
    public List<MedicationResponse> getAllMedications();

    @PostMapping("medication/create")
    public MedicationResponse createMedication(@RequestBody MedicationResponse medicationRequest);

    @PutMapping("/updateMedication/{medicationId}")
    public MedicationResponse updateMedication(@PathVariable long medicationId, @RequestBody MedicationRequest medicationRequest);

    @DeleteMapping("/deleteMedication/{medicationId}")
    public MedicationResponse deleteMedication(@PathVariable long medicationId);
}
