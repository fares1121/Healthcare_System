package com.HCSBackEnd.HCS.Back.End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId; // SERIAL PRIMARY KEY

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId; // INT NOT NULL

    @Column(name = "patient_id", nullable = false)
    private Long patientId; // INT NOT NULL

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate; // DATE NOT NULL

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime; // TIME NOT NULL

    @Column(name = "duration", nullable = false)
    private Integer duration; // INT NOT NULL

    @Column(name = "reason_for_visit", nullable = false)
    private String reasonForVisit; // TEXT NOT NULL
}
