package com.example.Vaccination_booking_System.Service;


import com.example.Vaccination_booking_System.DTO.RequestDto.AppointmentReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.AppointmentResponseDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.CenterResDto;
import com.example.Vaccination_booking_System.Exception.DoctorNotFound;
import com.example.Vaccination_booking_System.Exception.PersonNotfoundException;
import com.example.Vaccination_booking_System.Model.Appointment;
import com.example.Vaccination_booking_System.Model.Doctor;
import com.example.Vaccination_booking_System.Model.Person;
import com.example.Vaccination_booking_System.Model.VaccinationCenter;
import com.example.Vaccination_booking_System.Repository.AppointmentRepository;
import com.example.Vaccination_booking_System.Repository.DoctorRepository;
import com.example.Vaccination_booking_System.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {


    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PersonRepository personRepository;


    @Autowired
    DoctorRepository doctorRepository;


    @Autowired
    JavaMailSender javaMailSender;


    public AppointmentResponseDto bookAppointment(AppointmentReqDto appointmentReqDto) {


        Optional<Person>  optionalPerson = personRepository.findById(appointmentReqDto.getPersonId());

        if(optionalPerson.isEmpty()) throw new PersonNotfoundException("Invalid Person Req");

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentReqDto.getDoctorId());

        if(optionalDoctor.isEmpty()) throw new DoctorNotFound("Invalid Doctor Req");

        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();


        // create new Apponintment

        Appointment  appointment = new Appointment();

        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);


        Appointment savedAppointment = appointmentRepository.save(appointment);


        doctor.getAppointments().add(savedAppointment);
        person.getAppointments().add(savedAppointment);


       Doctor savedDoctor = doctorRepository.save(doctor);
       Person savedPerson = personRepository.save(person);




        // create appoitmenet repsonsedto

        VaccinationCenter vaccinationCenter = savedDoctor.getVaccinationCenter();



        //send an email

        String text  = "Congratulations! "+savedPerson.getName()+ " your Appointment for vaccination  dose 2 is confirmed with "+
                savedDoctor.getName()+" at the VaccinationCenter Name is "+vaccinationCenter.getCenterName()+ " is at the address "+  vaccinationCenter.getAddress()+" at this time "+ savedAppointment.getAppointmentDate()+" Dhanyawadamulu";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mohanchandra1819@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congratulations! Appointment has confirmed");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);


        CenterResDto centerResDto = new CenterResDto();

        centerResDto.setCenterType(vaccinationCenter.getCenterType());
        centerResDto.setCenterName(vaccinationCenter.getCenterName());
        centerResDto.setAddress(vaccinationCenter.getAddress());

        AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto();

        appointmentResponseDto.setAppointmentId(savedAppointment.getAppointmentId());
        appointmentResponseDto.setAppointmentDate(savedAppointment.getAppointmentDate());
        appointmentResponseDto.setPersonName(savedPerson.getName());
        appointmentResponseDto.setDoctorName(savedDoctor.getName());
        appointmentResponseDto.setCenterResDto(centerResDto);

        return appointmentResponseDto;
  }
}
