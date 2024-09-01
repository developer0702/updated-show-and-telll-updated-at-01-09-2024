package com.appointment.controller;


import com.appointment.entity.Appointment;
import com.appointment.response.AppointmentResponse;
import com.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;


    @GetMapping("/getAppsByDid/{did}")
    public List<AppointmentResponse> getAppsByDid(@PathVariable long did) {
        List<AppointmentResponse> appointments = appointmentService.getDoctorApposByDid(did);
        return appointments;
    }

    @GetMapping("/getAppsByPid/{pid}")
    public List<AppointmentResponse> getAppsByPid(@PathVariable long pid) {
        List<AppointmentResponse> appointments = appointmentService.getPatientApposByPid(pid);

        return appointments;
    }

    @GetMapping("/getAppByID/{id}")
    public AppointmentResponse getAppById(@PathVariable long id) {
        AppointmentResponse appointment = appointmentService.getAppointmentById(id);
        System.out.println(appointment.toString());
        return appointment;

    }

    @PostMapping("/create")
    public AppointmentResponse CreateAppointment(@RequestBody Appointment appointment) {
        return appointmentService.CreateAppointment(appointment);

    }

    @PutMapping("/edit/{id}")
    public AppointmentResponse EditAppointment(@RequestBody Appointment appointment, @PathVariable long id) {
        appointment.setAid(id);

        return CreateAppointment(appointment);

    }

    @DeleteMapping("/detete/{aid}")
    public boolean DeleteAppoointment(@PathVariable long aid) {
        return appointmentService.DeleteAppointment(aid);
    }

    @GetMapping("/status/{aid}/{st}")
    public boolean ChangeStatus(@PathVariable long aid, @PathVariable int st) {
        AppointmentResponse appointment = getAppById(aid);
        if (st == 1) {
            appointment.setStatus("Appointment Booked");
        } else {
            appointment.setStatus("Rejected");

        }
        Appointment appo = new Appointment();
        appo.setAid(appointment.getAid());
        appo.setDid(appointment.getDid());
        appo.setPid(appointment.getPid());
        appo.setStatus(appointment.getStatus());
        appo.setDate(appointment.getDate());
        appo.setTime(appointment.getTime());

        CreateAppointment(appo);

        return true;
    }

//    @PostMapping("/updateAppointmentByDoctor/{aid}")
//    public ResponseEntity<AppointmentResponse> updateAppointmentByDoctor(@PathVariable long aid, @RequestBody Appointment appointment) {
//        AppointmentResponse appointmentResponse = appointmentService.updateAppointmentByDoctor(aid, appointment);
//        return new ResponseEntity<>(appointmentResponse, HttpStatus.OK);
//    }
}
