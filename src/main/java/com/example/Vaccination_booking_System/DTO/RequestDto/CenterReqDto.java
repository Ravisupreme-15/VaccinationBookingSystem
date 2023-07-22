package com.example.Vaccination_booking_System.DTO.RequestDto;

import com.example.Vaccination_booking_System.Enum.CenterType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterReqDto {

    String centerName;

    CenterType centerType;

    String address;
}
