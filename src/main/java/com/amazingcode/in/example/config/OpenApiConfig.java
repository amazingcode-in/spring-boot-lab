package com.amazingcode.in.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Spring-Boot-Lab",
        version = "v1.0.0",
        description = "Spring Boot Lab API documentation"
    )
)
public class OpenApiConfig {
}
