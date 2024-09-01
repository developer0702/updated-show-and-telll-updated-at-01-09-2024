package com.doctor.response;

import com.doctor.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {


    private long did;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String role;
    private String specialization;


    public DoctorResponse(Doctor doctor) {
        this.did = doctor.getDid();
        this.email = doctor.getEmail();
        this.password = doctor.getPassword();
        this.fullName = doctor.getFullName();
        this.address = doctor.getAddress();
        this.role = doctor.getRole();
        this.specialization = doctor.getSpecialization();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}
