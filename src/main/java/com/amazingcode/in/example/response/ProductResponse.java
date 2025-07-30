package com.amazingcode.in.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {
    private Long productId;
    private String productName;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private Double price;
    private CategoryResponse category;
}