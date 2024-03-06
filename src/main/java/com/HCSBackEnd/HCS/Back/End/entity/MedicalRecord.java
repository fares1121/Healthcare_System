package com.HCSBackEnd.HCS.Back.End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId; // SERIAL PRIMARY KEY

    @Column(name = "patient_id", nullable = false)
    private Long patientId; // INT NOT NULL

    @Column(name = "date_of_visit", nullable = false)
    private Date dateOfVisit; // DATE NOT NULL

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId; // INT NOT NULL

    @Column(name = "diagnosis")
    private String diagnosis; // TEXT

    @Column(name = "treatment")
    private String treatment; // TEXT

    @Column(name = "prescription")
    private String prescription; // TEXT

}
