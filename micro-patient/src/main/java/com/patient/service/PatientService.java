package com.patient.service;


import com.patient.openfegin.MedicationFiegn;
import com.patient.request.MedicationRequest;
import com.patient.response.MedicationResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.repo.PatientRepository;
import com.patient.response.DoctorResponse;
import com.patient.response.PatientResponse;

import java.util.List;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepo;

	@Autowired
	private PasswordEncoder passwordEncode;

	@Autowired
	private MedicationFiegn medicationFiegn;

	//Getting patient details by id
	public Patient getById(long id) {
		//Getting patient by id from database with the help of JPA Repo
		Patient patient = patientRepo.findById(id).get();
		return patient;
	}

	public PatientResponse getByEmail(String email) {
		//Getting patient by id from database with the help of JPA Repo
		Patient patient = patientRepo.findByEmail(email);
		return new PatientResponse(patient);

	}

	//To create the new Patient
	public Patient createUser(Patient patient) {
		patient.setPassword(passwordEncode.encode(patient.getPassword()));
		patient.setRole("ROLE_PATIENT");
		return patientRepo.save(patient);
	}
	public boolean DeletePatient(long id) {
		Patient patient= patientRepo.findById(id).get();
		patientRepo.delete(patient);

		return !(patientRepo.existsById(id));
	}

	//To create the Update Patient
		public Patient UpdatePatient(Patient patient) {
			Patient patientNew=getById(patient.getId());
			patient.setPassword(patientNew.getPassword());

			patient.setRole("ROLE_PATIENT");
			return patientRepo.save(patient);
		}
}
