package com.HCSBackEnd.HCS.Back.End.service;

import com.HCSBackEnd.HCS.Back.End.dto.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {
    PrescriptionDto createPrescription(PrescriptionDto prescriptionDto);
    PrescriptionDto getPrescriptionById(Long prescriptionId);
    List<PrescriptionDto> getPrescriptionsByPatientId(Long patientId);
    PrescriptionDto updatePrescription(Long prescriptionId, PrescriptionDto updatedPrescription);
    void deletePrescription(Long prescriptionId);
}
