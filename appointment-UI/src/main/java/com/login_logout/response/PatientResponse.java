package com.login_logout.response;

public class PatientResponse {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String fullName;

    private String email;

    private String address;

    private String password;
    private long mobileno;

    private String role;


    @Override
    public String toString() {
        return "PatientResponse [id=" + id + ", fullName=" + fullName + ", email=" + email + ", address=" + address
                + ", password=" + password + ", mobileno=" + mobileno + ", role=" + role + "]";
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
