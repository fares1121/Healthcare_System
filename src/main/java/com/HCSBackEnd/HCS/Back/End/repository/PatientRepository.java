package com.HCSBackEnd.HCS.Back.End.repository;

import com.HCSBackEnd.HCS.Back.End.entity.Appointment;
import com.HCSBackEnd.HCS.Back.End.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByUsername(String username);
}
