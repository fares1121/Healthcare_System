package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.dto.DoctorDto;
import com.HCSBackEnd.HCS.Back.End.security.config.auth.User;
import com.HCSBackEnd.HCS.Back.End.service.Doctorservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private Doctorservice doctorservice;

    //Build add Doctor API
    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto saveDoctor = doctorservice.createDoctor(doctorDto);
        return new ResponseEntity<>(saveDoctor, HttpStatus.CREATED);
    }

    //Get Doctor Method
    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("id") Long doctorId){
        DoctorDto doctorDto = doctorservice.getDoctorById(doctorId);
        return ResponseEntity.ok(doctorDto);
    }

    //Get ALL Doctors
    @GetMapping("doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> doctors = doctorservice.getAllDoctor();
        return ResponseEntity.ok(doctors);
    }

    //Update Doctor API
    @PutMapping("{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long doctorId, @RequestBody DoctorDto updatedDoctor){
        DoctorDto doctorDto = doctorservice.updateDoctor(doctorId, updatedDoctor);
        return ResponseEntity.ok(doctorDto);
    }

    //Delete Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId){
        doctorservice.deleteDoctor(doctorId);
        return ResponseEntity.ok("Doctor deleted successfully!");
    }
}
