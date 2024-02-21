CREATE TABLE medical_records (
  record_id SERIAL PRIMARY KEY,
  patient_id INT NOT NULL,
  date_of_visit DATE NOT NULL,
  doctor_id INT NOT NULL,
  diagnosis TEXT,
  treatment TEXT,
  prescription TEXT,
  CONSTRAINT fk_patient
      FOREIGN KEY (patient_id)
      REFERENCES patients (patient_id),
  CONSTRAINT fk_doctor
      FOREIGN KEY (doctor_id)
      REFERENCES doctors (doctor_id)
);
