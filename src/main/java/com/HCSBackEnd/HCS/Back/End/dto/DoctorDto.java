package com.HCSBackEnd.HCS.Back.End.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//class to transfer data from client to server
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private Long doctorId; // SERIAL PRIMARY KEY

    private String username;

    private String password;
    private String firstName; // VARCHAR(50) NOT NULL
    private String lastName; // VARCHAR(50) NOT NULL
    private String specialization; // VARCHAR(100) NOT NULL
    private String emailAddress; // VARCHAR(100) UNIQUE
    private String phoneNumber; // VARCHAR(20)
    private String currentAddress; // VARCHAR(100)
}
