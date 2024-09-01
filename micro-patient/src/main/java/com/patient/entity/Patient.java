package com.patient.entity;

import com.patient.request.MedicationRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;

    private String email;

    private String address;

    private String password;

    private long mobileno;

    private String refferingPhysician;

    private String role;

    public String getRefferingPhysician() {
        return refferingPhysician;
    }

    public void setRefferingPhysician(String refferingPhysician) {
        this.refferingPhysician = refferingPhysician;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }


}
