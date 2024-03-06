package com.HCSBackEnd.HCS.Back.End.repository;

import com.HCSBackEnd.HCS.Back.End.entity.Appointment;
import com.HCSBackEnd.HCS.Back.End.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
}
