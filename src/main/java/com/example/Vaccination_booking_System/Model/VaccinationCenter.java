package com.example.Vaccination_booking_System.Model;


import com.example.Vaccination_booking_System.Enum.CenterType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VaccinationCenter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


   CenterType centerType;
    String address;



}
