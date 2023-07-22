package com.example.Vaccination_booking_System.DTO.ResponseDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {

    String appointmentId;

    Date appointmentDate;

    String personName;

    String doctorName;

    CenterResDto centerResDto;
}
