package com.example.Vaccination_booking_System.Service;


import com.example.Vaccination_booking_System.Model.Person;
import com.example.Vaccination_booking_System.Repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {



    @Autowired
    PersonRepository personRepository;


    public Person addPerson(Person person)
    {


        person.setIsDose1Taken(false);
        person.setIsDose2Taken(false);


        Person person1 = personRepository.save(person);

        return person1;
    }
}
