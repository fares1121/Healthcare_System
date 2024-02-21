CREATE TABLE patients (
  patient_id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  date_of_birth DATE NOT NULL,
  gender VARCHAR(10) NOT NULL,
  current_address text NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  insurance_provider VARCHAR(100) NOT NULL,
  insurance_policy_number VARCHAR(100) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
