package com.HCSBackEnd.HCS.Back.End.dto;

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
public class PrescriptionDto {

    private Long prescriptionId; // SERIAL PRIMARY KEY
    private Long patientId; // LONG NOT NULL
    private Long doctorId; // LONG NOT NULL
    private String medicationName; // VARCHAR(100) NOT NULL
    private String dosage; // VARCHAR(50) NOT NULL
    private String frequency; // VARCHAR(50) NOT NULL
    private String instructions; // TEXT
    private Date prescriptionStartDate; // DATE NOT NULL
    private Date prescriptionEndDate; // DATE
    private Timestamp createdAt; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    private Timestamp updatedAt; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP
}
