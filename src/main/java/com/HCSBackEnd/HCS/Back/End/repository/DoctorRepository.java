package com.HCSBackEnd.HCS.Back.End.repository;

import com.HCSBackEnd.HCS.Back.End.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
