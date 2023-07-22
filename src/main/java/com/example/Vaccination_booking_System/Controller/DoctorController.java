package com.example.Vaccination_booking_System.Controller;


import com.example.Vaccination_booking_System.DTO.RequestDto.DoctorReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.DoctorResDto;
import com.example.Vaccination_booking_System.Model.Doctor;
import com.example.Vaccination_booking_System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.net.DatagramPacket;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {



 @Autowired

 DoctorService doctorService;


 @PostMapping("/add_doctor")
    public ResponseEntity addDoctor(@RequestBody DoctorReqDto doctorReqDto){

       try{
            DoctorResDto doctorResDto = doctorService.addDoctor(doctorReqDto);
            return new ResponseEntity(doctorResDto, HttpStatus.ACCEPTED);

        }
       catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);

       }


    }



    // doctors whose age is greaterthan 25

    @GetMapping("/get_listofdoctors")
    public  ResponseEntity getAllDoctors(@RequestParam("age") int age){


       try{
            List<String> doctorList = doctorService.getAllDoctors(age);

            return new ResponseEntity(doctorList,HttpStatus.ACCEPTED);

        }
       catch (Exception e){

           return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
       }

    }



    // get the doctors with highest number of appointments


    // get the list of doctors who belong  to particular center


    // api to update and email and/or age of a doctor





}
