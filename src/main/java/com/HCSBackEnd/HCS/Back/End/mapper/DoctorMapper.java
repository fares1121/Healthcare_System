package com.HCSBackEnd.HCS.Back.End.mapper;

import com.HCSBackEnd.HCS.Back.End.dto.DoctorDto;
import com.HCSBackEnd.HCS.Back.End.entity.Doctor;

import javax.print.Doc;

public class DoctorMapper {

    public static DoctorDto mapToDoctorDto(Doctor doctor){
        return new DoctorDto(
                doctor.getDoctorId(),
                doctor.getUsername(),
                doctor.getPassword(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialization(),
                doctor.getEmailAddress(),
                doctor.getPhoneNumber(),
                doctor.getCurrentAddress()
        );
    }

    //Method will map doctor to JP doctor entity
    public static Doctor mapToDoctor(DoctorDto doctorDto){
        return new Doctor(
                doctorDto.getDoctorId(),
                doctorDto.getUsername(),
                doctorDto.getPassword(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getSpecialization(),
                doctorDto.getEmailAddress(),
                doctorDto.getPhoneNumber(),
                doctorDto.getCurrentAddress()
        );
    }
}
