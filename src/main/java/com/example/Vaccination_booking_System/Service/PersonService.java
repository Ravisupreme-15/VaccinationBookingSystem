package com.example.Vaccination_booking_System.Service;


import com.example.Vaccination_booking_System.DTO.RequestDto.AddPersonReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.AddPersonResDto;
import com.example.Vaccination_booking_System.Model.Person;
import com.example.Vaccination_booking_System.Repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;


    public AddPersonResDto addPerson(AddPersonReqDto addPersonReqDto) {


        // convert req dto to entitiy

        Person person = new Person();

        person.setName(addPersonReqDto.getName());
        person.setEmailId(addPersonReqDto.getEmailId());
        person.setGender(addPersonReqDto.getGender());
        person.setAge(addPersonReqDto.getAge());
        person.setIsDose1Taken(false);
        person.setIsDose2Taken(false);
        person.setCertificate(null);


        Person savedPerson = personRepository.save(person);

        AddPersonResDto addPersonResDto = new AddPersonResDto();
        addPersonResDto.setMessage("Congrats! you have been registered");
        addPersonResDto.setName(savedPerson.getName());
        return addPersonResDto;

    }

}



