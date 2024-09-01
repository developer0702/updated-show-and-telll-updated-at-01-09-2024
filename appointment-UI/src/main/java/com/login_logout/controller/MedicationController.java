package com.login_logout.controller;


import com.login_logout.response.MedicationResponse;
import com.login_logout.service.MedicationService;
import com.login_logout.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/medication")
public class MedicationController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicationService medicationService;


    @PostMapping("/create")
    public MedicationResponse createMedication(@ModelAttribute MedicationResponse medication) {
        medicationService.createMedicine(medication);
        return medication;
    }

    @GetMapping("/getMedicationByMedicationId/{medicationId}")
    public MedicationResponse getMedicationByMedicationId(@PathVariable long medicationId) {
        return medicationService.getMedicationByMedicationId(medicationId);
    }

    @GetMapping("getAllMedicationsByDid/{did}")
    public List<MedicationResponse> getAllMedicationsByDid(@PathVariable long did) {
        return medicationService.getAllMedicationsByDid(did);
    }

    //    getAllMedications
    @GetMapping("/getAllMedications")
    public List<MedicationResponse> getAllMedications() {
        return medicationService.getAllMedications();

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}