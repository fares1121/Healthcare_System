package com.HCSBackEnd.HCS.Back.End.security;

import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base32;

public class SecurityUtil {

  public static String generateSecretKey() {
    SecureRandom random = createSecureRandom();
    byte[] bytes = new byte[10]; // 10 bytes = 80 bits
    random.nextBytes(bytes);
    Base32 base32 = new Base32();
    return base32.encodeToString(bytes); // Encode the random bytes in base32 format
  }

  // Method to obtain a SecureRandom instance, with a fallback mechanism
  private static SecureRandom createSecureRandom() {
        try {
            return SecureRandom.getInstanceStrong(); // Attempt to use strong instance
        } catch (NoSuchAlgorithmException e) {
            return new SecureRandom(); // Fallback to default (still cryptographically strong as per JDK standard)
        }
    }
  }
