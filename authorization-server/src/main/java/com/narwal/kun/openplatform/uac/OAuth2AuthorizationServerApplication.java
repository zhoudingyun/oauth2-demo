package com.narwal.kun.openplatform.uac;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuth2AuthorizationServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2AuthorizationServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
