package com.example.Vaccination_booking_System.DTO.RequestDto;

import com.example.Vaccination_booking_System.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BookDose1ReqDto {


    int  personId;

    DoseType doseType;
}
