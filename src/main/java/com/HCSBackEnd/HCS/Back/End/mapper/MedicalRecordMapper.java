package com.HCSBackEnd.HCS.Back.End.mapper;

import com.HCSBackEnd.HCS.Back.End.dto.MedicalRecordDto;
import com.HCSBackEnd.HCS.Back.End.entity.MedicalRecord;

public class MedicalRecordMapper {

    public static MedicalRecordDto mapToMedicalRecordDto(MedicalRecord medicalRecord) {
        return new MedicalRecordDto(
                medicalRecord.getRecordId(),
                medicalRecord.getPatientId(),
                medicalRecord.getDateOfVisit(),
                medicalRecord.getDoctorId(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getTreatment(),
                medicalRecord.getPrescription()

        );
    }

    public static MedicalRecord mapToMedicalRecord(MedicalRecordDto medicalRecordDto) {
        return new MedicalRecord(
                medicalRecordDto.getRecordId(),
                medicalRecordDto.getPatientId(),
                medicalRecordDto.getDateOfVisit(),
                medicalRecordDto.getDoctorId(),
                medicalRecordDto.getDiagnosis(),
                medicalRecordDto.getTreatment(),
                medicalRecordDto.getPrescription()

        );
    }
}
