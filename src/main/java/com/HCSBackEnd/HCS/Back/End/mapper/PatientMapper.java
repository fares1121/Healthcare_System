package com.HCSBackEnd.HCS.Back.End.mapper;

import com.HCSBackEnd.HCS.Back.End.dto.PatientDto;
import com.HCSBackEnd.HCS.Back.End.entity.Patient;

public class PatientMapper {

    public static PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getPatientId(),
                patient.getUsername(),
                patient.getPassword(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getCurrentAddress(),
                patient.getPhoneNumber(),
                patient.getEmail(),
                patient.getInsuranceProvider(),
                patient.getInsurancePolicyNumber(),
                patient.getCreatedAt()
        );
    }

    public static Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getPatientId(),
                patientDto.getUsername(),
                patientDto.getPassword(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getDateOfBirth(),
                patientDto.getGender(),
                patientDto.getCurrentAddress(),
                patientDto.getPhoneNumber(),
                patientDto.getEmail(),
                patientDto.getInsuranceProvider(),
                patientDto.getInsurancePolicyNumber(),
                patientDto.getCreatedAt()
        );
    }
}
