package com.appointment.openfegin;

import com.appointment.response.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway")
public interface DoctorOpenFegin {

    @GetMapping("micro-doctor/doctor/getById/{did}")
    DoctorResponse getById(@PathVariable long did);


}
