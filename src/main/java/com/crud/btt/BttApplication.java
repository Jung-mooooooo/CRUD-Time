package com.crud.btt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BttApplication {

    public static void main(String[] args) {
        SpringApplication.run(BttApplication.class, args);
    }

}
