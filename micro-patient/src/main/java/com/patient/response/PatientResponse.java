package com.patient.response;

import com.patient.entity.Patient;

public class PatientResponse {

	private long id;

	private String fullName;

	private String email;

	private String address;

	private String password;
	private long mobileno;

	private String role;

	private AppointmentResponse appointment;

	public AppointmentResponse getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentResponse appointment) {
		this.appointment = appointment;
	}

	public PatientResponse(Patient patient) {
		super();
		this.id = patient.getId();
		this.fullName = patient.getFullName();

		this.email = patient.getEmail();
		this.address = patient.getAddress();
		this.password = patient.getPassword();
		this.mobileno = patient.getMobileno();
		this.role = patient.getRole();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

}
