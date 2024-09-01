package com.login_logout.controller;

import com.login_logout.request.DiagnosisRequest;
import com.login_logout.request.MedicationRequest;
import com.login_logout.response.AppointmentResponse;
import com.login_logout.response.DiagnosisResponse;
import com.login_logout.response.DoctorResponse;
import com.login_logout.response.MedicationResponse;
import com.login_logout.service.DiagnosisService;
import com.login_logout.service.DoctorService;
import com.login_logout.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    MedicationService medicationService;

    @Autowired
    DiagnosisService diagnosisService;

    @ModelAttribute
    private void doctorDetails(Model m, Principal p) {
        String email = p.getName();

        DoctorResponse doctorResponse = doctorService.getByEmail(email);
        m.addAttribute("doctor", doctorResponse);

    }

    @GetMapping("/")
    public String home() {

        return "doctor_view/home";
    }

    @GetMapping("/Apps/{did}")
    public String getAllAppoinmentByDID(@PathVariable long did, Model model) {
        List<AppointmentResponse> appos = doctorService.getAllAppointmentByDID(did);

        appos.sort(Comparator.comparing(AppointmentResponse::getDate).thenComparing(AppointmentResponse::getTime));
        model.addAttribute("appos", appos);

        return "doctor_view/appointments";
    }

    @GetMapping("/edit")
    public String EditProfile() {
        return "doctor_view/profile";
    }

    @PostMapping("/update/{did}")
    public String updateDoctor(@ModelAttribute DoctorResponse doctor, @PathVariable long did, Model model) {
        DoctorResponse docExist = doctorService.getDoctorByDID(did);
        doctor.setPassword(docExist.getPassword());
        DoctorResponse doctorRes = doctorService.UpdateDoctor(doctor);
        model.addAttribute("doctor", doctorRes);

        return "doctor_view/home";
    }

    @GetMapping("/editAppointmentByPhysician/{aid}")
    public String EditAppointmentByPhysician(@PathVariable long aid, Model model) {
        AppointmentResponse appointmentResponse = doctorService.getAppointmentByAID(aid);
        model.addAttribute("appointment", appointmentResponse);
        System.out.println("appointmentResponse by doctor " + appointmentResponse.toString());
        return "doctor_view/editAppointment";
    }

    @GetMapping("/status/{aid}/{st}")
    public String ChangeStatusAppo(@PathVariable long aid, @PathVariable int st) {
        doctorService.UpdateAppoStatus(aid, st);
        return "doctor_view/home";
    }

    @PostMapping("/updateAppointmentByPhysician/{did}/{id}")
    public String UpdateAppointment(@ModelAttribute("appointment") AppointmentResponse appointment, @ModelAttribute MedicationRequest medicationRequest, @ModelAttribute DiagnosisRequest diagnosisRequest,@PathVariable("did") long did, @PathVariable("id") long id, HttpSession session) {
        appointment.setDid(did);
        appointment.setPid(id);
        appointment.setStatus("Pending");
        System.out.println(appointment);
        System.out.println(medicationRequest);

        System.out.println(diagnosisRequest);

        // Add medication to the appointment
        MedicationResponse medicationResponse = new MedicationResponse();
        medicationResponse.setName(medicationRequest.getName());
        medicationResponse.setDose(medicationRequest.getDose());
        medicationResponse.setRoute(medicationRequest.getRoute());
        medicationResponse.setFrequency(medicationRequest.getFrequency());
        medicationResponse.setUnitOfMeasure(medicationRequest.getUnitOfMeasure());
        medicationResponse.setStartDate(medicationRequest.getStartDate());
        medicationResponse.setTime(medicationRequest.getTime());
        medicationResponse.setEndDate(medicationRequest.getEndDate());
        medicationResponse.setPid(appointment.getPid());
        medicationResponse.setDid(appointment.getDid());
        medicationService.createMedicine(medicationResponse); // Create the medication
//        appointment.setMedication(medicationRequest.getMedicationResponse());

        DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
        diagnosisResponse.setConditionCodes(diagnosisRequest.getConditionCodes());
        diagnosisResponse.setStatus(diagnosisRequest.getStatus());
        diagnosisResponse.setCategory(diagnosisRequest.getCategory());
        diagnosisResponse.setSeverity(diagnosisRequest.getSeverity());
        diagnosisResponse.setBodySite(diagnosisRequest.getBodySite());
        diagnosisResponse.setOnset(diagnosisRequest.getOnset());
        diagnosisResponse.setAbatement(diagnosisRequest.getAbatement());
        diagnosisResponse.setStage(diagnosisRequest.getStage());
        diagnosisResponse.setEvidence(diagnosisRequest.getEvidence());
        diagnosisResponse.setNote(diagnosisRequest.getNote());
        diagnosisResponse.setDid(appointment.getDid());
        diagnosisResponse.setPid(appointment.getPid());
        diagnosisService.createDiagnosis(diagnosisResponse); // Create the diagnosis
//        appointment.setDiagnosis(diagnosisRequest.getDiagnosisResponse());
        // Create the diagnosis
        List<AppointmentResponse> appos = doctorService.getAllAppointmentByDID(did);
        System.out.println(appos);
        if (isAppointmentTimeAvailable(appos, appointment)) {
            doctorService.updateAppointmentByDoctor(appointment);
            session.setAttribute("booked", "Appointment Updated.");
            return "redirect:/doctor/Apps/" + appointment.getDid() + "?success=true";
        } else {
            session.setAttribute("error", "Appointment time is already booked for patient within 30 minutes. Please choose a different time.");
            return "redirect:/doctor/Apps/" + did;
        }
    }

    @GetMapping("/appointments/search/{did}")
    public String searchAppointments(@PathVariable long did, @RequestParam(defaultValue = "") String searchQuery, Model model) {
        List<AppointmentResponse> appos = doctorService.getAllAppointmentByDID(did);

        if (!searchQuery.isEmpty()) {
            appos = appos.stream()
                    .filter(appointment -> fuzzySearch(appointment, searchQuery))
                    .collect(Collectors.toList());
        }

        System.out.println(appos.size() + "---");

        model.addAttribute("appos", appos);
        model.addAttribute("searchQuery", searchQuery);

        return "doctor_view/appointments";
    }

    private boolean fuzzySearch(AppointmentResponse appointment, String searchQuery) {
        String fullName = appointment.getPatientResponse().getFullName().toLowerCase();
        String date = appointment.getDate().toString().toLowerCase();
        String time = appointment.getTime().toString().toLowerCase();

        searchQuery = searchQuery.toLowerCase();

        return fullName.contains(searchQuery) || date.contains(searchQuery) || time.contains(searchQuery);
    }

    private boolean isAppointmentTimeAvailable(List<AppointmentResponse> existingAppointments, AppointmentResponse newAppointment) {
        for (AppointmentResponse existingAppointment : existingAppointments) {
            if (existingAppointment.getDate().equals(newAppointment.getDate())) {
                long minutesDiff = ChronoUnit.MINUTES.between(existingAppointment.getTime(), newAppointment.getTime());
                if (Math.abs(minutesDiff) <= 30) {
                    return false;
                }
            }
        }
        return true;
    }
}

