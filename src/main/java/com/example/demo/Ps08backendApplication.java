package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo", "controller"})
public class Ps08backendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ps08backendApplication.class, args);
    }
}
