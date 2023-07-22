package com.example.Vaccination_booking_System.Exception;

public class EmptyListException extends RuntimeException {
    public EmptyListException(String theListIsEmpty) {

        super(theListIsEmpty);
    }
}
