package com.example.Vaccination_booking_System.Controller;


import com.example.Vaccination_booking_System.DTO.RequestDto.AppointmentReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.AppointmentResponseDto;
import com.example.Vaccination_booking_System.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/appointment")

public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;


  @PostMapping("/Book_appointment")
    public ResponseEntity  bookAppointment(@RequestBody  AppointmentReqDto appointmentReqDto){

        try{
            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentReqDto);

            return new  ResponseEntity(appointmentResponseDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
