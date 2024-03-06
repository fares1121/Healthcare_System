package com.HCSBackEnd.HCS.Back.End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId; // SERIAL PRIMARY KEY

    @Column(name = "first_name")
    private String firstName; // VARCHAR(50) NOT NULL

    @Column(name = "last_name")
    private String lastName; // VARCHAR(50) NOT NULL

    @Column(name = "specialization")
    private String specialization; // VARCHAR(100) NOT NULL

    @Column(name = "email")
    private String emailAddress; // VARCHAR(100) UNIQUE

    @Column(name = "phone_number")
    private String phoneNumber; // VARCHAR(20)
    private String currentAddress; // VARCHAR(100)

}
