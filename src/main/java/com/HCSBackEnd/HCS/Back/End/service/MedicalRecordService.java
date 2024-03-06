package com.HCSBackEnd.HCS.Back.End.service;

import com.HCSBackEnd.HCS.Back.End.dto.MedicalRecordDto;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto);
    MedicalRecordDto getMedicalRecordById(Long recordId);
    List<MedicalRecordDto> getMedicalRecordsByPatientId(Long patientId);
    MedicalRecordDto updateMedicalRecord(Long recordId, MedicalRecordDto updatedMedicalRecord);
    void deleteMedicalRecord(Long recordId);
}
