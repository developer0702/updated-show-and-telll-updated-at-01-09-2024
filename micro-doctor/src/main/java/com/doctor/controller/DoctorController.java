package com.doctor.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.doctor.response.MedicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.doctor.entity.Doctor;
import com.doctor.response.AppointmentResponse;
import com.doctor.response.DoctorResponse;
import com.doctor.service.CommonService;
import com.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	CommonService commonService;

	@GetMapping("/all")
	public List<DoctorResponse> GetAllDoctors() {
		return doctorService.getAllDoctors();
	}
	@GetMapping("/getById/{id}")
	public DoctorResponse getById(@PathVariable long id) {
		return doctorService.getById(id);
	}
	
	@GetMapping("/getByEmail/{email}")
	public DoctorResponse getByEmail(@PathVariable String email) {
		return doctorService.getByEmail(email);
	}
	
	@PostMapping("/register")
	public DoctorResponse CreateDoctor(@RequestBody Doctor doctor) {
		
		return doctorService.CreateDoctor(doctor);
		
	}
	
	@PutMapping("/update/{id}")
	public Doctor UpdateDoctor(@RequestBody Doctor doctor, @PathVariable long id) {
		doctor.setDid(id);
		
		return doctorService.UpdateDoctor(doctor);
		
	}
	@DeleteMapping("/delete/{id}")
	public String DeleteDoctor(@PathVariable long id) {
		return doctorService.DeleteDoctor(id);
		
	}
	
	@GetMapping("/appos/{id}")
	public List<AppointmentResponse> GetApposById(@PathVariable long id) {
		return commonService.DoctorAppointment(id) ;
		
	}
	
	@GetMapping("/status/{aid}/{st}")
	public boolean ChangeStatus(@PathVariable long aid, @PathVariable int st) {
		commonService.ChangeStatus(aid, st);
		return true;
	}

	@PostMapping("/updateAppointmentByDoctor")
	public ResponseEntity<AppointmentResponse> updateAppointmentByDoctor(  @RequestBody AppointmentResponse appointmentResponse) {
		AppointmentResponse updatedAppointment = commonService.updateAppointmentByDoctor(appointmentResponse);
		return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
	}

	@GetMapping("/getAllMedicationsByDid/{did}")
	public ResponseEntity<List<MedicationResponse> > getAllMedicationsByDid(@PathVariable long did){
		List<MedicationResponse> allMedicationsByDid = commonService.getAllMedicationsByDid(did);
		return new ResponseEntity<>(allMedicationsByDid,HttpStatus.OK);
	}
	@GetMapping("/AppByAid/{aid}")
	public AppointmentResponse getAppointmentByAID(@PathVariable long aid) {
		AppointmentResponse appointment = commonService.GetPaaointmentByAID(aid);
		System.out.println("ms doctor-: "+appointment.toString());
		return appointment;
	}
}
