package com.amazingcode.in.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootLabApplication {
    
    private static final Logger LOG = LoggerFactory.getLogger(SpringBootLabApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLabApplication.class, args);
        LOG.info("Application started successfully.");
    }
}
