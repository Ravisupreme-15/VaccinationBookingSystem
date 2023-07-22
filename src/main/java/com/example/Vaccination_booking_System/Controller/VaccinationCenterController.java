package com.example.Vaccination_booking_System.Controller;


import com.example.Vaccination_booking_System.DTO.RequestDto.CenterReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.CenterResDto;
import com.example.Vaccination_booking_System.Model.VaccinationCenter;
import com.example.Vaccination_booking_System.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/center")
public class VaccinationCenterController {


    @Autowired
   VaccinationCenterService vaccinationCenterService;

// adding vaccination center

    @PostMapping("/add=Vcenter")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterReqDto centerReqDto){

        try {
            CenterResDto center = vaccinationCenterService.addVaccinationcnCenter(centerReqDto);


             return new ResponseEntity(center,HttpStatus.ACCEPTED);
        }

        catch (Exception e){

            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }




    }
}
