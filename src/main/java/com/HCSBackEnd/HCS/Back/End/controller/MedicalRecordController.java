package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.dto.MedicalRecordDto;
import com.HCSBackEnd.HCS.Back.End.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/medical-record")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordDto> createMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto) {
        MedicalRecordDto createdMedicalRecord = medicalRecordService.createMedicalRecord(medicalRecordDto);
        return new ResponseEntity<>(createdMedicalRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<MedicalRecordDto> getMedicalRecordById(@PathVariable("recordId") Long recordId) {
        MedicalRecordDto medicalRecordDto = medicalRecordService.getMedicalRecordById(recordId);
        return ResponseEntity.ok(medicalRecordDto);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecordDto>> getMedicalRecordsByPatientId(@PathVariable("patientId") Long patientId) {
        List<MedicalRecordDto> medicalRecords = medicalRecordService.getMedicalRecordsByPatientId(patientId);
        return ResponseEntity.ok(medicalRecords);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<MedicalRecordDto> updateMedicalRecord(@PathVariable("recordId") Long recordId,
                                                                @RequestBody MedicalRecordDto updatedMedicalRecord) {
        MedicalRecordDto medicalRecordDto = medicalRecordService.updateMedicalRecord(recordId, updatedMedicalRecord);
        return ResponseEntity.ok(medicalRecordDto);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable("recordId") Long recordId) {
        medicalRecordService.deleteMedicalRecord(recordId);
        return ResponseEntity.ok("Medical record deleted successfully!");
    }
}
