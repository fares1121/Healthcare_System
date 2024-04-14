package com.HCSBackEnd.HCS.Back.End.service.impl;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    private static final int VERIFICATION_CODE_LENGTH = 6; // Length of the verification code
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    // Generate a random verification code
    public String generateVerificationCode() {
        byte[] codeBytes = new byte[VERIFICATION_CODE_LENGTH];
        SECURE_RANDOM.nextBytes(codeBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(codeBytes).substring(0, VERIFICATION_CODE_LENGTH);
    }

    // Validate the verification code entered by the user
    public boolean validateVerificationCode(String enteredCode, String generatedCode) {
        // Implement your validation logic here
        return enteredCode.equals(generatedCode);
    }
}
