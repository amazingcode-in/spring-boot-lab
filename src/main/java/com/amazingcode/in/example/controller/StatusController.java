package com.amazingcode.in.example.controller;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/status")
@Tag(name = "Health Check API", description = "Provides application status information")
public class StatusController {

    private final Logger logger = LoggerFactory.getLogger(StatusController.class);
    
    @Operation(summary = "Get application status", description = "Returns a message indicating whether the application is running.")
    @GetMapping
    public ResponseEntity<String> statusMessage(){
        logger.info("Request received for application status at {}", Instant.now());
        String message = "Spring Boot Lab is running... | Timestamp: " + Instant.now();
        logger.info("Returning application status message: {}", message);
        return ResponseEntity.ok(message);
    }
}
