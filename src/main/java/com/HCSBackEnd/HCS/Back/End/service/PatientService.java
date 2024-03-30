package com.HCSBackEnd.HCS.Back.End.service;

import com.HCSBackEnd.HCS.Back.End.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto getPatientById(Long patientId);
    List<PatientDto> getAllPatients();
    PatientDto updatePatient(Long patientId, PatientDto updatedPatient);
    void deletePatient(Long patientId);

}
