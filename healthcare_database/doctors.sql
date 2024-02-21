CREATE TABLE doctors (
  doctor_id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  specialization VARCHAR(100) NOT NULL,
  email_address VARCHAR(100) UNIQUE,
  phone_number VARCHAR(20),
  current_address VARCHAR(100)
);
