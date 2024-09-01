package com.login_logout.openfegin;

import com.login_logout.response.MedicationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "api-gateway")
public interface MedicationFiegn {

    @GetMapping("micro-medication/medications/getMedication/{medicationId}")
    public MedicationResponse getByMedicationId(@PathVariable long medicationId);

    @GetMapping("micro-medication/medications/getAllMedications")
    public List<MedicationResponse> getAllMedications();

    @PostMapping("micro-medication/medications/create")
    public MedicationResponse createMedication(@RequestBody MedicationResponse medication);

    @PutMapping("micro-medication/medications/updateMedication/{medicationId}")
    public MedicationResponse updateMedication( @RequestBody MedicationResponse medicationResponse,@PathVariable long medicationId);

    @DeleteMapping("micro-medication/medications/deleteMedication/{medicationId}")
    public boolean deleteMedication(@PathVariable long medicationId);

    @GetMapping("micro-medication/medications/getAllMedicationsByPid/{pid}")
    public List<MedicationResponse> getAllMedicationsByPid(@PathVariable long pid) ;

    @GetMapping("micro-medication/medications/getAllMedicationsByDid/{did}")
    public List<MedicationResponse> getAllMedicationsByDid(@PathVariable long did) ;

    }
