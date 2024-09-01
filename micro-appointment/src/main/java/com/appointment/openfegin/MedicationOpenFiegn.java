package com.appointment.openfegin;

import com.appointment.response.MedicationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "micro-medication")
public interface MedicationOpenFiegn {

    @GetMapping("medication/getById/{medicationId}")
    public MedicationResponse getByMedicationId(@PathVariable long medicationId );


}
