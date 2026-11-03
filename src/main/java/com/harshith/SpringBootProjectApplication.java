package com.harshith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;

@SpringBootApplication
@RestController
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @GetMapping
    public String helloWorld() {
        return "Hello harshith";
    }
}