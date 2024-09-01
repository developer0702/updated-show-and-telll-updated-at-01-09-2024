package com.patient.openfegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.patient.response.DoctorResponse;

@FeignClient("micro-doctor")
public interface DoctorOpenFegin {

	
	@GetMapping("/doctor/all")
	public List<DoctorResponse> GetAllDoctors();
	
	@GetMapping("/doctor/getById/{id}")
	public DoctorResponse getById(@PathVariable long id);
}
