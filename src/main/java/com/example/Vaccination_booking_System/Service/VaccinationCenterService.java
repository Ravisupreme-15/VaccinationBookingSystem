package com.example.Vaccination_booking_System.Service;

import com.example.Vaccination_booking_System.DTO.RequestDto.CenterReqDto;
import com.example.Vaccination_booking_System.DTO.ResponseDto.CenterResDto;
import com.example.Vaccination_booking_System.Model.VaccinationCenter;
import com.example.Vaccination_booking_System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

   @Autowired
   VaccinationCenterRepository vaccinationCenterRepository;
    public CenterResDto addVaccinationcnCenter(CenterReqDto centerReqDto) {

           // dto - entity
          VaccinationCenter center = new VaccinationCenter();

          center.setCenterName(centerReqDto.getCenterName());
          center.setCenterType(centerReqDto.getCenterType());
          center.setAddress(centerReqDto.getAddress());


          // saving entity to the database
          VaccinationCenter savedcenter = vaccinationCenterRepository.save(center);


          // entity - dto

         CenterResDto  centerResDto = new CenterResDto();

         centerResDto.setCenterName(savedcenter.getCenterName());
         centerResDto.setCenterType(savedcenter.getCenterType());
         centerResDto.setAddress(savedcenter.getAddress());


         return centerResDto;






    }
}
