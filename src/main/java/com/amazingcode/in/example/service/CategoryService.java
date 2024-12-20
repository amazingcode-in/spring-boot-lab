package com.amazingcode.in.example.service;

import com.amazingcode.in.example.request.CategoryRequest;
import com.amazingcode.in.example.response.CategoryResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    CategoryResponse getCategory(Long id);
    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);
    void deleteCategory(Long id);
}