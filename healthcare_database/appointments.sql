CREATE TABLE appointments (
    appointment_id SERIAL PRIMARY KEY,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    duration INT NOT NULL,
    reason_for_visit TEXT NOT NULL,
    CONSTRAINT fk_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctors (doctor_id),
    CONSTRAINT fk_patient
        FOREIGN KEY (patient_id)
        REFERENCES patients (patient_id)
);
