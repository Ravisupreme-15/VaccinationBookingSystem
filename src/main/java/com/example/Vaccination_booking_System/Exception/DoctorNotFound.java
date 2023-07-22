package com.example.Vaccination_booking_System.Exception;

public class DoctorNotFound extends RuntimeException {
    public DoctorNotFound(String invalidDoctorReq) {

        super(invalidDoctorReq);
    }
}
