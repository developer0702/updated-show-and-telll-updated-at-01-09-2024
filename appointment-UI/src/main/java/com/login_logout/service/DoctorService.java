package com.login_logout.service;


import com.login_logout.response.AppointmentResponse;
import com.login_logout.response.DoctorResponse;

import java.util.List;


public interface DoctorService {

    DoctorResponse createUser(DoctorResponse doctor);

    boolean checkEmail(String email);

    DoctorResponse getByEmail(String email);

    List<AppointmentResponse> getAllAppointmentByDID(long did);

    DoctorResponse getDoctorByDID(long did);

    DoctorResponse UpdateDoctor(DoctorResponse doctor);

    boolean UpdateAppoStatus(long aid, int st);

    AppointmentResponse getAppointmentByAID(long aid);

    AppointmentResponse updateAppointmentByDoctor(AppointmentResponse appointment);
}
