package com.patient.exception;

public class AppointmentException extends RuntimeException {

    // Constructor for general exceptions
    public AppointmentException(String message) {
        super(message);
    }

    // Constructor for exceptions with a cause
    public AppointmentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Nested static classes for specific exceptions
    public static class AllreadyBookException extends AppointmentException {
        public AllreadyBookException(String message) {
            super(message);
        }

        public AllreadyBookException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class PatientNotExistException extends AppointmentException {
        public PatientNotExistException(String message) {
            super(message);
        }

        public PatientNotExistException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

