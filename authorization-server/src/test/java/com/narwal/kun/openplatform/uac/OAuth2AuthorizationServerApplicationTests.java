package com.narwal.kun.openplatform.uac;

import com.narwal.kun.openplatform.uac.common.utils.Pbkdf2Sha256Utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.UUID;


public class OAuth2AuthorizationServerApplicationTests {


    public static void main(String[] args) {
        PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        String passrod = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(passrod);
        System.out.println(passwordEncoder.encode("secret"));

    }

}
