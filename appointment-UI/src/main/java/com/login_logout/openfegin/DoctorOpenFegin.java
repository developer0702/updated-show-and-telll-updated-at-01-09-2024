package com.login_logout.openfegin;


import com.login_logout.response.AppointmentResponse;
import com.login_logout.response.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "api-gateway")
public interface DoctorOpenFegin {

    @GetMapping("micro-doctor/doctor/getByEmail/{email}")
    public DoctorResponse getByEmail(@PathVariable String email);

    @PostMapping("micro-doctor/doctor/register")
    public DoctorResponse CreateDoctor(@RequestBody DoctorResponse doctor);

    @GetMapping("micro-doctor/doctor/getById/{id}")
    public DoctorResponse getById(@PathVariable long id);

    @PutMapping("micro-doctor/doctor/update/{id}")
    public DoctorResponse UpdateDoctor(@RequestBody DoctorResponse doctor, @PathVariable long id);

    @GetMapping("micro-doctor/doctor/status/{aid}/{st}")
    public boolean ChangeStatus(@PathVariable long aid, @PathVariable int st);

    @GetMapping("micro-doctor/doctor/appos/{id}")
    public List<AppointmentResponse> GetApposById(@PathVariable long id);

    @GetMapping("micro-doctor/doctor/AppByAid/{aid}")
    public AppointmentResponse getAppointmentByAID(@PathVariable long aid);

    @PostMapping("/micro-doctor/doctor/updateAppointmentByDoctor")
    public AppointmentResponse modifyAppointmentByDoctor(@RequestBody AppointmentResponse appointmentResponse);
}
