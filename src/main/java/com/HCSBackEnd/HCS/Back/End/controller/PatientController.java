package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.dto.PatientDto;
import com.HCSBackEnd.HCS.Back.End.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        PatientDto savedPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long patientId){
        PatientDto patientDto = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientDto);
    }

    @GetMapping("patients")
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List<PatientDto> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long patientId, @RequestBody PatientDto updatedPatient){
        PatientDto patientDto = patientService.updatePatient(patientId, updatedPatient);
        return ResponseEntity.ok(patientDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long patientId){
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient deleted successfully!");
    }
}
