package com.HCSBackEnd.HCS.Back.End.service.impl;

import com.HCSBackEnd.HCS.Back.End.dto.PatientDto;
import com.HCSBackEnd.HCS.Back.End.entity.Patient;
import com.HCSBackEnd.HCS.Back.End.exception.ResourceNotFoundException;
import com.HCSBackEnd.HCS.Back.End.mapper.PatientMapper;
import com.HCSBackEnd.HCS.Back.End.repository.PatientRepository;
import com.HCSBackEnd.HCS.Back.End.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = PatientMapper.mapToPatient(patientDto);
        Patient savePatient = patientRepository.save(patient);
        return PatientMapper.mapToPatientDto(savePatient);
    }

    @Override
    public PatientDto getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient does not exist with ID: " + patientId));
        return PatientMapper.mapToPatientDto(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::mapToPatientDto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(Long patientId, PatientDto updatedPatient) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        patient.setGender(updatedPatient.getGender());
        patient.setCurrentAddress(updatedPatient.getCurrentAddress());
        patient.setPhoneNumber(updatedPatient.getPhoneNumber());
        patient.setEmail(updatedPatient.getEmail());
        patient.setInsuranceProvider(updatedPatient.getInsuranceProvider());
        patient.setInsurancePolicyNumber(updatedPatient.getInsurancePolicyNumber());

        Patient updatedPatientObj = patientRepository.save(patient);
        return PatientMapper.mapToPatientDto(updatedPatientObj);
    }

    @Override
    public void deletePatient(Long patientId) {
        if (!patientRepository.existsById(patientId)) {
            throw new ResourceNotFoundException("Patient not found with ID: " + patientId);
        }
        patientRepository.deleteById(patientId);
    }
}
