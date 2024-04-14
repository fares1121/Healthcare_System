package com.HCSBackEnd.HCS.Back.End.service;

import com.HCSBackEnd.HCS.Back.End.dto.DoctorDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.CredentialsDto;

import java.util.List;

public interface Doctorservice {
    DoctorDto createDoctor(DoctorDto doctorDto);
    DoctorDto getDoctorById(Long doctorId);

    List<DoctorDto> getAllDoctor();

    DoctorDto updateDoctor(Long doctorId, DoctorDto updatedDoctor );

    void deleteDoctor(Long doctorId);


}
