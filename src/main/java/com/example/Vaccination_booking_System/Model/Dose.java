package com.example.Vaccination_booking_System.Model;


import com.example.Vaccination_booking_System.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dose {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String DoseId;

    @Enumerated(value = EnumType.STRING)
    DoseType doseType;

    @CreationTimestamp
    Date vaccinationDate;


    @ManyToOne
    @JoinColumn
    Person person;




}
