package com.example.Vaccination_booking_System.DTO.RequestDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentReqDto {

     int personId;

     int doctorId;

}
