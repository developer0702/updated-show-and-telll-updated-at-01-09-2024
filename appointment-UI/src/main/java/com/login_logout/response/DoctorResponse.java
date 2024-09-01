package com.login_logout.response;




public class DoctorResponse {
	

private long did;
private String email;
private String role;
private String password;
private String fullName;
private String address;

private String specialization;



public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public long getDid() {
	return did;
}
public void setDid(long did) {
	this.did = did;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




}
