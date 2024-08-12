package com.agagagah.bankingv2.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class BcryptEncoder {


    public static String encode(String password){
         int strength = 10;
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());

         return bCryptPasswordEncoder.encode(password);
    }

    public static boolean decode(String plain, String encoded){
         int strength = 10;
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.matches(plain, encoded);
    }
}
