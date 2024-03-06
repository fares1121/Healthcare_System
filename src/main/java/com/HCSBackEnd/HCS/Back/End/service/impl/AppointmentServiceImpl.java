package com.HCSBackEnd.HCS.Back.End.service.impl;

import com.HCSBackEnd.HCS.Back.End.dto.AppointmentDto;
import com.HCSBackEnd.HCS.Back.End.entity.Appointment;
import com.HCSBackEnd.HCS.Back.End.exception.ResourceNotFoundException;
import com.HCSBackEnd.HCS.Back.End.mapper.AppointmentMapper;
import com.HCSBackEnd.HCS.Back.End.repository.AppointmentRepository;
import com.HCSBackEnd.HCS.Back.End.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.mapToAppointmentDto(savedAppointment);
    }

    @Override
    public AppointmentDto getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));
        return AppointmentMapper.mapToAppointmentDto(appointment);
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(AppointmentMapper::mapToAppointmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto updateAppointment(Long appointmentId, AppointmentDto updatedAppointment) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        // Update appointment fields
        appointment.setDoctorId(updatedAppointment.getDoctorId());
        appointment.setPatientId(updatedAppointment.getPatientId());
        appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        appointment.setDuration(updatedAppointment.getDuration());
        appointment.setReasonForVisit(updatedAppointment.getReasonForVisit());

        Appointment updated = appointmentRepository.save(appointment);
        return AppointmentMapper.mapToAppointmentDto(updated);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new ResourceNotFoundException("Appointment not found with ID: " + appointmentId);
        }
        appointmentRepository.deleteById(appointmentId);
    }
}
