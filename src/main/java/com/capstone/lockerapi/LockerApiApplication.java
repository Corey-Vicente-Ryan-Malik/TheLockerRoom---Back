package com.capstone.lockerapi;

import com.capstone.lockerapi.models.User;
import com.capstone.lockerapi.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LockerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockerApiApplication.class, args);
    }
}
