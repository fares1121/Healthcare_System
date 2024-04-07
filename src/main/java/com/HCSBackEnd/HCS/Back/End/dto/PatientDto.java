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
public class PatientDto {

    private Long patientId;

    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String currentAddress;
    private String phoneNumber;
    private String email;
    private String insuranceProvider;
    private String insurancePolicyNumber;
    private Timestamp createdAt;
}
