package com.amazingcode.in.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amazingcode.in.example.constant.enums.CategoryResponseMessage;
import com.amazingcode.in.example.request.CategoryRequest;
import com.amazingcode.in.example.response.CategoryResponse;
import com.amazingcode.in.example.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        LOG.info("Initializing CategoryController");
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        LOG.info("Received request to create category: {}", categoryRequest);
        CategoryResponse createdCategory = categoryService.createCategory(categoryRequest);
        LOG.info("Successfully created category with ID: {}", createdCategory.getCategoryId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") Long id) {
        LOG.info("Fetching category with ID: {}", id);
        CategoryResponse category = categoryService.getCategory(id);
        LOG.info("Successfully retrieved category: {}", category);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable("id") Long id,
            @RequestBody CategoryRequest categoryRequest) {
        LOG.info("Updating category with ID: {}", id);
        CategoryResponse updatedCategory = categoryService.updateCategory(id, categoryRequest);
        LOG.info("Successfully updated category: {}", updatedCategory);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        LOG.info("Attempting to delete category with ID: {}", id);
        categoryService.deleteCategory(id);
        LOG.info("Successfully deleted category with ID: {}", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(CategoryResponseMessage.CATEGORY_SUCCESSFULLY_DELETED.getMessage(id));
    }
}
