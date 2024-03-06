package com.HCSBackEnd.HCS.Back.End.service;

import com.HCSBackEnd.HCS.Back.End.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);
    AppointmentDto getAppointmentById(Long appointmentId);
    List<AppointmentDto> getAllAppointments();
    AppointmentDto updateAppointment(Long appointmentId, AppointmentDto updatedAppointment);
    void deleteAppointment(Long appointmentId);
}
