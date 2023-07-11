package com.example.Vaccination_booking_System.Service;

import com.example.Vaccination_booking_System.Enum.DoseType;
import com.example.Vaccination_booking_System.Exception.Dose1AlreadyTaken;
import com.example.Vaccination_booking_System.Exception.PersonNotfoundException;
import com.example.Vaccination_booking_System.Model.Dose;
import com.example.Vaccination_booking_System.Model.Person;
import com.example.Vaccination_booking_System.Repository.DoseRepository;
import com.example.Vaccination_booking_System.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;

    public Dose addDose1(int personId, DoseType doseType) {


        Optional<Person> Optionalperson = personRepository.findById(personId);

        // check if person exists or not

        if(!Optionalperson.isPresent()){

             throw new PersonNotfoundException("Invalid Person");
        }

        Person person = Optionalperson.get();

         // check the person istakendose1 or not

        if(person.getIsDose1Taken()){

            throw new Dose1AlreadyTaken("Person already taken dose1");
        }

        // create a dose

        Dose dose = new Dose();

        dose.setDoseId(String.valueOf(UUID.randomUUID()));

        dose.setDoseType(doseType);

        dose.setPerson(person);

        person.setIsDose1Taken(true);

        personRepository.save(person);

        return doseRepository.save(dose);




    }
}
