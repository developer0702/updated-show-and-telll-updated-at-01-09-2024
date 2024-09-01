package com.patient.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int statusCode;
    private String message;

    public ApiResponse(HttpStatus httpStatus, String message) {
        this.statusCode = httpStatus.value();
        this.message = message;
    }

    public ApiResponse(String message, boolean b) {
        this.statusCode = b ? HttpStatus.OK.value() : HttpStatus.BAD_REQUEST.value();
        this.message = message;
    }
}
