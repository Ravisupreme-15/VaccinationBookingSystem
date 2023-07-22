package com.example.Vaccination_booking_System.Controller;


import com.example.Vaccination_booking_System.DTO.RequestDto.AddPersonReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.AddPersonResDto;
import com.example.Vaccination_booking_System.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // update the old email to newemail

    @PutMapping("/update-email")
    public  ResponseEntity updateEmailid(@RequestParam("oldemail") String oldemail,@RequestParam("newemail") String newmail){

          try{
              String  response = personService.updateEmailid(oldemail,newmail);

              return new ResponseEntity(response,HttpStatus.ACCEPTED);

          }
          catch (Exception e){

              return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
          }

    }


    // get all males  of age greaterthan a certain age
    @GetMapping("/Listof_allPersons")
    public ResponseEntity  getAllPersonAgeGreaterThan(@RequestParam("age") int age){

        try{
            List<String> listofPeople = personService.getAllPersonAgeGreaterThan(age);

            return new ResponseEntity(listofPeople,HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }



    // get  all females who have taken only dose 1 not dose2

    @GetMapping("/get_All_Female")
    public ResponseEntity  getAllFemalesWhoHaveTakendose1NotDose2(){


        try{
            List<String> femaleList = personService.getAllFemalesWhoHaveTakendose1NotDose2();

            return new ResponseEntity(femaleList,HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }




    // get all people who are fully vaccinated

    @GetMapping("/getPeople_fullyVaccinated")
    public ResponseEntity getPeopleFullyVaccinated(){

        try {
            List<String> list = personService.getPeopleFullyVaccinated();
            return new ResponseEntity(list,HttpStatus.ACCEPTED);
        }
        catch (Exception e){

             return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }


    // get all people who have not taken a single dose

    @GetMapping("/peopleNotTakenSingleDose")
    public  ResponseEntity getAllPeopleNotTakenSingleDose()
    {


        try
        {
            List<String> list = personService.getAllPeopleNotTakenSingleDose();
            return new ResponseEntity(list,HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }



    // get all females whose age is greater than a particular age and who have taken only dose1


    @GetMapping("/GetAllFemales")
     public  ResponseEntity getAllFemaleAgeGreaterThanandTakenDose1(@RequestParam("age") int age){

        try {
            List<String> list = personService.getAllFemaleAgeGreaterThanandTakenDose1(age);
            return new ResponseEntity(list,HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
     }

    // get all males whose age is greater than a particular age and who have taken both doses


   @GetMapping("/AllMaleWithAgeGreaterNoDose")
    public ResponseEntity  getAllMaleAgeGreaterThanNoDose(@RequestParam("age") int age){
       try{
            List<String> list = personService.getAllMaleAgeGreaterThanNoDose(age);
            return new ResponseEntity(list,HttpStatus.ACCEPTED);
        }

       catch (Exception e){

           return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
       }


    }
}
