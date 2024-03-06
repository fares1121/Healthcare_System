package com.HCSBackEnd.HCS.Back.End.mapper;

import com.HCSBackEnd.HCS.Back.End.dto.PrescriptionDto;
import com.HCSBackEnd.HCS.Back.End.entity.Prescription;

public class PrescriptionMapper {

    public static PrescriptionDto mapToPrescriptionDto(Prescription prescription) {
        return new PrescriptionDto(
                prescription.getPrescriptionId(),
                prescription.getPatientId(),
                prescription.getDoctorId(),
                prescription.getMedicationName(),
                prescription.getDosage(),
                prescription.getFrequency(),
                prescription.getInstructions(),
                prescription.getPrescriptionStartDate(),
                prescription.getPrescriptionEndDate(),
                prescription.getCreatedAt(),
                prescription.getUpdatedAt()

        );
    }

    public static Prescription mapToPrescription(PrescriptionDto prescriptionDto) {
        return new Prescription(
                prescriptionDto.getPrescriptionId(),
                prescriptionDto.getPatientId(),
                prescriptionDto.getDoctorId(),
                prescriptionDto.getMedicationName(),
                prescriptionDto.getDosage(),
                prescriptionDto.getFrequency(),
                prescriptionDto.getInstructions(),
                prescriptionDto.getPrescriptionStartDate(),
                prescriptionDto.getPrescriptionEndDate(),
                prescriptionDto.getCreatedAt(),
                prescriptionDto.getUpdatedAt()
        );
    }
}
