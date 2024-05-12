package org.example.services.hashing;

import org.example.services.hashing.interfaces.HashingService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingSHA256Service implements HashingService {
    @Override
    public String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error creating hash", e);
        }
    }
}