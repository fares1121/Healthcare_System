package com.HCSBackEnd.HCS.Back.End.repository;


import com.HCSBackEnd.HCS.Back.End.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository <MedicalRecord, Long>{
    List<MedicalRecord> findByPatientId(Long patientId);
}
