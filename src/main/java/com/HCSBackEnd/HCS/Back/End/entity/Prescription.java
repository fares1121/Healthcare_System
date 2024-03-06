package com.HCSBackEnd.HCS.Back.End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private Long prescriptionId; // SERIAL PRIMARY KEY

    @Column(name = "patient_id")
    private Long patientId; // INT NOT NULL

    @Column(name = "doctor_id")
    private Long doctorId; // INT NOT NULL

    @Column(name = "medication_name")
    private String medicationName; // VARCHAR(100) NOT NULL

    @Column(name = "dosage")
    private String dosage; // VARCHAR(50) NOT NULL

    @Column(name = "frequency")
    private String frequency; // VARCHAR(50) NOT NULL

    @Column(name = "instructions")
    private String instructions; // TEXT

    @Column(name = "prescription_start_date")
    private Date prescriptionStartDate; // DATE NOT NULL

    @Column(name = "prescription_end_date")
    private Date prescriptionEndDate; // DATE

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Getter
    @Setter
    private Timestamp createdAt; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Getter
    @Setter
    private Timestamp updatedAt; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP

}
