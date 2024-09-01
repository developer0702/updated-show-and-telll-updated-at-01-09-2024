package com.appointment.response;


public class PatientResponse {

	private long id;

	private String fullName;

	private String email;

	private String address;

	private long mobileno;



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
