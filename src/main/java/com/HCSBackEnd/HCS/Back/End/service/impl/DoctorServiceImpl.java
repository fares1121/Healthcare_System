package com.HCSBackEnd.HCS.Back.End.service.impl;

import com.HCSBackEnd.HCS.Back.End.dto.DoctorDto;
import com.HCSBackEnd.HCS.Back.End.entity.Doctor;
import com.HCSBackEnd.HCS.Back.End.exception.ResourceNotFoundException;
import com.HCSBackEnd.HCS.Back.End.mapper.DoctorMapper;
import com.HCSBackEnd.HCS.Back.End.repository.DoctorRepository;
import com.HCSBackEnd.HCS.Back.End.service.Doctorservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements Doctorservice {

    private DoctorRepository doctorRepository;
    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = DoctorMapper.mapToDoctor(doctorDto);
        Doctor saveDoctor = doctorRepository.save(doctor);
        return DoctorMapper.mapToDoctorDto(saveDoctor);
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor does not exist with that ID: "+doctorId));
        return DoctorMapper.mapToDoctorDto(doctor);
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        List <Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map((doctor) -> DoctorMapper.mapToDoctorDto(doctor))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto updateDoctor(Long doctorId, DoctorDto updatedDoctor) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () ->
                        new ResourceNotFoundException("Doctor not Found by ID: "+ doctorId)
        );
        doctor.setFirstName(updatedDoctor.getFirstName());
        doctor.setLastName(updatedDoctor.getLastName());
        doctor.setSpecialization(updatedDoctor.getSpecialization());
        doctor.setEmailAddress(updatedDoctor.getEmailAddress());
        doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
        doctor.setCurrentAddress(updatedDoctor.getCurrentAddress());

        Doctor updatedDoctorObj = doctorRepository.save(doctor);
        return DoctorMapper.mapToDoctorDto(updatedDoctorObj);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () ->
                        new ResourceNotFoundException("Doctor not Found by ID: "+ doctorId)
        );
        doctorRepository.deleteById(doctorId);
    }
}
