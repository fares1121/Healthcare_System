package com.HCSBackEnd.HCS.Back.End.repository;

import com.HCSBackEnd.HCS.Back.End.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
