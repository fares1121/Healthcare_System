CREATE TABLE doctors_login (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    email_address VARCHAR(100) UNIQUE,
    phone_number VARCHAR(20) UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    CONSTRAINT fk_email_address
      FOREIGN KEY (email_address)
      REFERENCES doctors (email_address),
    CONSTRAINT fk_phone_number
      FOREIGN KEY (phone_number)
      REFERENCES doctors (phone_number)
);

-- Encrypt the passwords using bcrypt
ALTER TABLE doctors_login
    ALTER COLUMN password_hash SET DATA TYPE VARCHAR(255) USING password_hash::VARCHAR(255),
    ALTER COLUMN password_hash SET DEFAULT '';

-- Add a trigger to automatically hash the passwords before inserting or updating
CREATE OR REPLACE FUNCTION hash_password()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.password_hash := crypt(NEW.password_hash, gen_salt('bf'));
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER hash_password_trigger
    BEFORE INSERT OR UPDATE ON doctors_login
    FOR EACH ROW
    EXECUTE FUNCTION hash_password();
