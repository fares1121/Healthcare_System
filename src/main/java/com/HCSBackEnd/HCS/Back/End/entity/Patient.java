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
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId; // SERIAL PRIMARY KEY

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName; // VARCHAR(50) NOT NULL

    @Column(name = "last_name")
    private String lastName; // VARCHAR(50) NOT NULL

    @Column(name = "date_of_birth")
    private Date dateOfBirth; // DATE NOT NULL

    @Column(name = "gender")
    private String gender; // VARCHAR(10) NOT NULL

    @Column(name = "current_address", columnDefinition = "TEXT")
    private String currentAddress; // TEXT NOT NULL

    @Column(name = "phone_number")
    private String phoneNumber; // VARCHAR(20)

    @Column(name = "email")
    private String email; // VARCHAR(100) NOT NULL

    @Column(name = "insurance_provider")
    private String insuranceProvider; // VARCHAR(100) NOT NULL

    @Column(name = "insurance_policy_number")
    private String insurancePolicyNumber; // VARCHAR(100) NOT NULL

   @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   @Getter
   @Setter
   private Timestamp createdAt; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP
}
