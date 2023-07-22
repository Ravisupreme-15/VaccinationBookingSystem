package com.example.Vaccination_booking_System.DTO.RequestDto;

import com.example.Vaccination_booking_System.Enum.Gender;
import com.example.Vaccination_booking_System.Model.VaccinationCenter;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorReqDto {


    String name;

    int age;


    String emailId;


    Gender gender;

    int centerId;


}
