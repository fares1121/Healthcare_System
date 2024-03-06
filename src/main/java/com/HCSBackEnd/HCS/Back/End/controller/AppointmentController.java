package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.dto.AppointmentDto;
import com.HCSBackEnd.HCS.Back.End.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    // Add Appointment API
    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto savedAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    // Get Appointment by ID
    @GetMapping("{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable("id") Long appointmentId) {
        AppointmentDto appointmentDto = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointmentDto);
    }

    // Get All Appointments
    @GetMapping("appointments")
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    // Update Appointment API
    @PutMapping("{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable("id") Long appointmentId,
                                                            @RequestBody AppointmentDto updatedAppointment) {
        AppointmentDto appointmentDto = appointmentService.updateAppointment(appointmentId, updatedAppointment);
        return ResponseEntity.ok(appointmentDto);
    }

    // Delete Appointment API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("Appointment deleted successfully!");
    }
}
