package com.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctor.entity.Doctor;
import com.doctor.repo.DoctorRepo;
import com.doctor.response.AppointmentResponse;
import com.doctor.response.DoctorResponse;

@Service
public class DoctorService {

	@Autowired
	DoctorRepo doctorRepo;

	@Autowired
	private PasswordEncoder passwordEncode;


	public List<DoctorResponse> getAllDoctors() {
		List<Doctor> doctors = doctorRepo.findAll();
		List<DoctorResponse> doctorResponses = new ArrayList<DoctorResponse>();
		for (Doctor doc : doctors) {
			doctorResponses.add(new DoctorResponse(doc));
		}
		return doctorResponses;
	}

	public DoctorResponse getById(long id) {

		Doctor doctor = doctorRepo.findById(id).get();

		return new DoctorResponse(doctor);

	}

	public DoctorResponse getByEmail(String email) {

		Doctor doctor = doctorRepo.findByEmail(email);

		return new DoctorResponse(doctor);

	}

	public DoctorResponse CreateDoctor(Doctor doctor) {
		doctor.setPassword(passwordEncode.encode(doctor.getPassword()));
		doctor.setRole("ROLE_DOCTOR");
		doctorRepo.save(doctor);

		return new DoctorResponse(doctor);
	}

	public Doctor UpdateDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	public String DeleteDoctor(long id) {
		Doctor doctor = doctorRepo.findById(id).get();
		doctorRepo.delete(doctor);
		return "Doctor Account Successfully deleted";
	}


}
