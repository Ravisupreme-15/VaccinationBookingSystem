package com.example.Vaccination_booking_System.Repository;


import com.example.Vaccination_booking_System.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {




    Person findByEmailId(String oldemail);

//    List<Person> findByAgeAndName(int age, String name);

     @Query(value = "Select * from person where age > :age",nativeQuery = true)
    List<Person> getPersonGreaterThan(int age);


     @Query(value ="select * from person where is_dose1taken = true and is_dose2taken=false", nativeQuery = true)
    List<Person> getAllFemalesWhoHaveTakendose1NotDose2();

    @Query(value ="select * from person where is_dose1taken = true and is_dose2taken = true", nativeQuery = true)
    List<Person> getPepleFullyVaccinated();


    @Query(value ="select * from person where is_dose1taken = false and is_dose2taken = false", nativeQuery = true)
    List<Person> getAllPeopleNotTakenSingleDose();


    @Query(value ="select * from person where is_dose1taken = true and is_dose2taken=false and age>:age", nativeQuery = true)
    List<Person> getAllFemaleAgeGreaterThanandTakenDose1(int age);



    @Query(value ="select * from person where is_dose1taken = true and is_dose2taken=true and age>:age", nativeQuery = true)
    List<Person> getAllMaleAgeGreaterThanNoDose(int age);
}
