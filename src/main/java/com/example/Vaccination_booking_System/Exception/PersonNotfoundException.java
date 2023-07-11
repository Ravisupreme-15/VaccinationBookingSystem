package com.example.Vaccination_booking_System.Exception;

public class PersonNotfoundException extends RuntimeException {
    public PersonNotfoundException(String invalidPerson) {

        super(invalidPerson);

    }
}
