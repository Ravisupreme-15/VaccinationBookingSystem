package com.example.Vaccination_booking_System.DTO.ResponseDto;

import com.example.Vaccination_booking_System.Enum.CenterType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterResDto {

    String centerName;


    CenterType centerType;

    String address;
}
