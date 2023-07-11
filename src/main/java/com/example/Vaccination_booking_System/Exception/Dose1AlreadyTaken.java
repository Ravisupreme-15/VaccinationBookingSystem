package com.example.Vaccination_booking_System.Exception;

public class Dose1AlreadyTaken extends RuntimeException {
    public Dose1AlreadyTaken(String personAlreadyTakenDose1) {

         super(personAlreadyTakenDose1);
    }
}
