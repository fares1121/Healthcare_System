package com.HCSBackEnd.HCS.Back.End.mapper;

import com.HCSBackEnd.HCS.Back.End.dto.AppointmentDto;
import com.HCSBackEnd.HCS.Back.End.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentDto mapToAppointmentDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getDoctorId(),
                appointment.getPatientId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getDuration(),
                appointment.getReasonForVisit()
        );
    }

    public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
        return new Appointment(
                appointmentDto.getAppointmentId(),
                appointmentDto.getDoctorId(),
                appointmentDto.getPatientId(),
                appointmentDto.getAppointmentDate(),
                appointmentDto.getAppointmentTime(),
                appointmentDto.getDuration(),
                appointmentDto.getReasonForVisit()
        );
    }
}
