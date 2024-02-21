CREATE TABLE prescriptions (
  prescription_id SERIAL PRIMARY KEY,
  patient_id INT NOT NULL,
  doctor_id INT NOT NULL,
  medication_name VARCHAR(100) NOT NULL,
  dosage VARCHAR(50) NOT NULL,
  frequency VARCHAR(50) NOT NULL,
  instructions TEXT,
  prescription_start_date DATE NOT NULL,
  prescription_end_date DATE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_patient
      FOREIGN KEY (patient_id)
      REFERENCES patients (patient_id),
  CONSTRAINT fk_doctor
      FOREIGN KEY (doctor_id)
      REFERENCES doctors (doctor_id)
);
