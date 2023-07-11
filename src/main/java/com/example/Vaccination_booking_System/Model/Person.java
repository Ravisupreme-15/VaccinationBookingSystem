package com.example.Vaccination_booking_System.Model;


import com.example.Vaccination_booking_System.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "person")
public class Person {


    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    String name;

    int age;

    @Column(unique = true)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;


     Boolean isDose1Taken;

     Boolean isDose2Taken;

//     @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
//     List<Dose> doseTaken = new ArrayList<>();
//
//
//
//   @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
//    Certificate certificate;
}

