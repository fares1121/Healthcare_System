package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.dto.PrescriptionDto;
import com.HCSBackEnd.HCS.Back.End.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        PrescriptionDto createdPrescription = prescriptionService.createPrescription(prescriptionDto);
        return new ResponseEntity<>(createdPrescription, HttpStatus.CREATED);
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable Long prescriptionId) {
        PrescriptionDto prescriptionDto = prescriptionService.getPrescriptionById(prescriptionId);
        return ResponseEntity.ok(prescriptionDto);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<PrescriptionDto>> getPrescriptionsByPatientId(@PathVariable Long patientId) {
        List<PrescriptionDto> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        return ResponseEntity.ok(prescriptions);
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionDto> updatePrescription(
            @PathVariable Long prescriptionId, @RequestBody PrescriptionDto updatedPrescription) {
        PrescriptionDto updatedPrescriptionDto = prescriptionService.updatePrescription(prescriptionId, updatedPrescription);
        return ResponseEntity.ok(updatedPrescriptionDto);
    }

    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
        return ResponseEntity.noContent().build();
    }
}
