package com.HCSBackEnd.HCS.Back.End.service.impl;

import com.HCSBackEnd.HCS.Back.End.dto.PrescriptionDto;
import com.HCSBackEnd.HCS.Back.End.entity.Prescription;
import com.HCSBackEnd.HCS.Back.End.exception.ResourceNotFoundException;
import com.HCSBackEnd.HCS.Back.End.mapper.PrescriptionMapper;
import com.HCSBackEnd.HCS.Back.End.repository.PrescriptionRepository;
import com.HCSBackEnd.HCS.Back.End.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Override
    public PrescriptionDto createPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = PrescriptionMapper.mapToPrescription(prescriptionDto);
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return PrescriptionMapper.mapToPrescriptionDto(savedPrescription);
    }

    @Override
    public PrescriptionDto getPrescriptionById(Long prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id: " + prescriptionId));
        return PrescriptionMapper.mapToPrescriptionDto(prescription);
    }

    @Override
    public List<PrescriptionDto> getPrescriptionsByPatientId(Long patientId) {
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
        return prescriptions.stream()
                .map(PrescriptionMapper::mapToPrescriptionDto)
                .collect(Collectors.toList());
    }

    @Override
    public PrescriptionDto updatePrescription(Long prescriptionId, PrescriptionDto updatedPrescription) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id: " + prescriptionId));

        prescription.setPatientId(updatedPrescription.getPatientId());
        prescription.setDoctorId(updatedPrescription.getDoctorId());
        prescription.setMedicationName(updatedPrescription.getMedicationName());
        prescription.setDosage(updatedPrescription.getDosage());
        prescription.setFrequency(updatedPrescription.getFrequency());
        prescription.setInstructions(updatedPrescription.getInstructions());
        prescription.setPrescriptionStartDate(updatedPrescription.getPrescriptionStartDate());
        prescription.setPrescriptionEndDate(updatedPrescription.getPrescriptionEndDate());

        Prescription updatedPrescriptionObj = prescriptionRepository.save(prescription);
        return PrescriptionMapper.mapToPrescriptionDto(updatedPrescriptionObj);
    }

    @Override
    public void deletePrescription(Long prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);
    }
}
