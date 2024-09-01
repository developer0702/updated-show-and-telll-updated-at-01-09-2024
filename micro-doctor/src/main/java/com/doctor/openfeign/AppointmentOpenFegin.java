package com.doctor.openfeign;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.doctor.response.MedicationResponse;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.doctor.response.AppointmentResponse;

@FeignClient(value="api-gateway")
public interface AppointmentOpenFegin {

	@GetMapping("micro-appointment/appointment/getAppsByDid/{did}")
	public List<AppointmentResponse> getAppsByDid(@PathVariable long did);

	@GetMapping("micro-appointment/appointment/status/{aid}/{st}")
	public boolean ChangeStatus(@PathVariable long aid, @PathVariable int st);

	@PostMapping("micro-appointment/appointment/create")
	AppointmentResponse CreateAppointment( @RequestBody AppointmentResponse appointmentResponse);

	@GetMapping("/micro-patient/medications/getAllMedicationsByDid/{did}")
	List<MedicationResponse> getAllMedicationsByDid(@PathVariable long did);

	@GetMapping("micro-appointment/appointment/getAppByID/{id}")
	public AppointmentResponse getAppById(@PathVariable long id);
}
