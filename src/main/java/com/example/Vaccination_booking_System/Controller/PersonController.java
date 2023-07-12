package com.example.Vaccination_booking_System.Controller;


import com.example.Vaccination_booking_System.DTO.RequestDto.AddPersonReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.AddPersonResDto;
import com.example.Vaccination_booking_System.Model.Person;
import com.example.Vaccination_booking_System.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Person")
public class PersonController {

    @Autowired
    PersonService personService;

    // add person

//    @PostMapping("/add_person")
//
//    public ResponseEntity addPerson(@RequestBody Person person){
//
//
//        try {
//            Person person1 = personService.addPerson(person);
//           return  new ResponseEntity(person1, HttpStatus.ACCEPTED);
//        }
//        catch (Exception e){
//
//            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
//        }
//
//        }

    @PostMapping("/add_person")

    public ResponseEntity addPerson(@RequestBody AddPersonReqDto addPersonReqDto){


        try {
            AddPersonResDto addPersonResDto = personService.addPerson(addPersonReqDto);
            return  new ResponseEntity(addPersonResDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
