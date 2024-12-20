package com.amazingcode.in.example.service;

import com.amazingcode.in.example.request.ProductRequest;
import com.amazingcode.in.example.response.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse getProduct(Long id);
    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    void deleteProduct(Long id);
}