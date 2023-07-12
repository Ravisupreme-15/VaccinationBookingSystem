package com.example.Vaccination_booking_System.Controller;


import com.example.Vaccination_booking_System.DTO.RequestDto.BookDose1ReqDto;
import com.example.Vaccination_booking_System.Enum.DoseType;
import com.example.Vaccination_booking_System.Model.Dose;
import com.example.Vaccination_booking_System.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Dose")
public class DoseController {

    @Autowired

    DoseService doseService;


//    @PostMapping("/add_dose")
//
//    public ResponseEntity addDose1(@RequestParam("id") int personId, @RequestParam("doseType")DoseType doseType){
//
//
//        try {
//            Dose dose = doseService.addDose1(personId,doseType);
//            return new ResponseEntity(dose,HttpStatus.ACCEPTED);
//
//        }
//        catch (Exception e){
//
//             return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
//        }


    @PostMapping("/add_dose")

    public ResponseEntity addDose1(@RequestBody BookDose1ReqDto bookDose1ReqDto){


        try {
            Dose dose = doseService.addDose1(bookDose1ReqDto);
            return new ResponseEntity(dose,HttpStatus.ACCEPTED);

        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

    }

}
