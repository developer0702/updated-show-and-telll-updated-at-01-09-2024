package com.login_logout.openfegin;


import java.util.List;

import com.login_logout.response.MedicationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.login_logout.response.AppointmentResponse;
import com.login_logout.response.DoctorResponse;
import com.login_logout.response.PatientResponse;

@FeignClient(value="api-gateway")
public interface PatientOpenFegin {

	@PostMapping("micro-patient/patient/register")
	public PatientResponse createuser(@RequestBody PatientResponse patient);

	@GetMapping("micro-patient/patient/getByEmail/{email}")
	public PatientResponse getByEmail(@PathVariable String email);

	@GetMapping("micro-patient/patient/Apps/{pid}")
	public List<AppointmentResponse> myAppos(@PathVariable long pid);

	@GetMapping("micro-patient/patient/doctors")
	public List<DoctorResponse> getAllDoctors();

	@GetMapping("micro-patient/patient/getById/{id}")
	public PatientResponse getById(@PathVariable long id);

	@PutMapping("micro-patient/patient/update/{id}")
	public PatientResponse Updatepatient(@RequestBody PatientResponse patient, @PathVariable long id);

	@GetMapping("micro-patient/patient/book/{did}")
	public DoctorResponse GetDoctorByDid(@PathVariable long did);

	@PostMapping("micro-patient/patient/book")
	public AppointmentResponse CreateAppointment(@RequestBody AppointmentResponse appointmentResponse);


	@GetMapping("micro-patient/patient/AppByAid/{aid}")
	public AppointmentResponse getAppointmentByAID(@PathVariable long aid);

	@DeleteMapping("/delete/{id}")
	public String DeletePatient(@PathVariable long id);

	@DeleteMapping("micro-patient/patient/deleteAppointemt/{aid}")
	public boolean DeleteAppointment(@PathVariable long aid);

	@GetMapping("micro-patient/patient/status/{aid}/{st}")
	public boolean ChangeStatus(@PathVariable long aid, @PathVariable int st);



}