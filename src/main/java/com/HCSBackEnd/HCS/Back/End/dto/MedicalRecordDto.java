package com.HCSBackEnd.HCS.Back.End.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordDto {

    private Long recordId; // SERIAL PRIMARY KEY
    private Long patientId; // INT NOT NULL
    private Date dateOfVisit; // DATE NOT NULL
    private Long doctorId; // INT NOT NULL
    private String diagnosis; // TEXT
    private String treatment; // TEXT
    private String prescription; // TEXT
}
