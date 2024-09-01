package com.appointment.openfegin;

import com.appointment.response.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "micro-patient")
public interface PatientOpenFegin {

    @GetMapping("patient/getById/{pid}")
    public PatientResponse getById(@PathVariable long pid);
}
