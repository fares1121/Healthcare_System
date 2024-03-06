package com.HCSBackEnd.HCS.Back.End.service.impl;

import com.HCSBackEnd.HCS.Back.End.dto.MedicalRecordDto;
import com.HCSBackEnd.HCS.Back.End.entity.MedicalRecord;
import com.HCSBackEnd.HCS.Back.End.exception.ResourceNotFoundException;
import com.HCSBackEnd.HCS.Back.End.mapper.MedicalRecordMapper;
import com.HCSBackEnd.HCS.Back.End.repository.MedicalRecordRepository;
import com.HCSBackEnd.HCS.Back.End.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = MedicalRecordMapper.mapToMedicalRecord(medicalRecordDto);
        MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return MedicalRecordMapper.mapToMedicalRecordDto(savedMedicalRecord);
    }

    @Override
    public MedicalRecordDto getMedicalRecordById(Long recordId) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical record not found with id: " + recordId));
        return MedicalRecordMapper.mapToMedicalRecordDto(medicalRecord);
    }

    @Override
    public List<MedicalRecordDto> getMedicalRecordsByPatientId(Long patientId) {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByPatientId(patientId);
        return medicalRecords.stream()
                .map(MedicalRecordMapper::mapToMedicalRecordDto)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalRecordDto updateMedicalRecord(Long recordId, MedicalRecordDto updatedMedicalRecord) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical record not found with id: " + recordId));

        medicalRecord.setPatientId(updatedMedicalRecord.getPatientId());
        medicalRecord.setDateOfVisit(updatedMedicalRecord.getDateOfVisit());
        medicalRecord.setDoctorId(updatedMedicalRecord.getDoctorId());
        medicalRecord.setDiagnosis(updatedMedicalRecord.getDiagnosis());
        medicalRecord.setTreatment(updatedMedicalRecord.getTreatment());
        medicalRecord.setPrescription(updatedMedicalRecord.getPrescription());

        MedicalRecord updatedRecord = medicalRecordRepository.save(medicalRecord);
        return MedicalRecordMapper.mapToMedicalRecordDto(updatedRecord);
    }

    @Override
    public void deleteMedicalRecord(Long recordId) {
        if (!medicalRecordRepository.existsById(recordId)) {
            throw new ResourceNotFoundException("Medical record not found with id: " + recordId);
        }
        medicalRecordRepository.deleteById(recordId);
    }
}
