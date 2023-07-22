package com.example.Vaccination_booking_System.DTO.ResponseDto;

import com.example.Vaccination_booking_System.DTO.RequestDto.CenterReqDto;
import com.example.Vaccination_booking_System.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResDto {

     String name;
     String message;

     CenterResDto centerResDto;
}
