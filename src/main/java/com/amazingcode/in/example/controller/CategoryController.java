package com.amazingcode.in.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amazingcode.in.example.constant.enums.CategoryResponseMessage;
import com.amazingcode.in.example.request.CategoryRequest;
import com.amazingcode.in.example.response.CategoryResponse;
import com.amazingcode.in.example.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category API", description = "Operations related to categories")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        LOG.info("Initializing CategoryController");
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create category", description = "Creates a new category")
    @ApiResponse(responseCode = "201", description = "Category created successfully")
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        LOG.info("Received request to create category: {}", categoryRequest);
        CategoryResponse createdCategory = categoryService.createCategory(categoryRequest);
        LOG.info("Successfully created category with ID: {}", createdCategory.getCategoryId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @Operation(summary = "Get all categories", description = "Retrieves a paginated list of all categories")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved categories")
    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAllCategory(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        LOG.info("Fetching categories page={}, size={}", page, size);
        Page<CategoryResponse> categories = categoryService.getAllCategory(PageRequest.of(page, size));
        LOG.info("Retrieved {} categories, total elements: {}", categories.getNumberOfElements(), categories.getTotalElements());
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @Operation(summary = "Get category by ID", description = "Retrieves a category by its unique ID")
    @ApiResponse(responseCode = "200", description = "Category retrieved successfully")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") Long id) {
        LOG.info("Fetching category with ID: {}", id);
        CategoryResponse category = categoryService.getCategory(id);
        LOG.info("Successfully retrieved category: {}", category);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @Operation(summary = "Update category", description = "Updates an existing category by ID")
    @ApiResponse(responseCode = "200", description = "Category updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable("id") Long id,
            @RequestBody CategoryRequest categoryRequest) {
        LOG.info("Updating category with ID: {}", id);
        CategoryResponse updatedCategory = categoryService.updateCategory(id, categoryRequest);
        LOG.info("Successfully updated category: {}", updatedCategory);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }

    @Operation(summary = "Delete category", description = "Deletes an existing category by ID")
    @ApiResponse(responseCode = "204", description = "Category deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        LOG.info("Attempting to delete category with ID: {}", id);
        categoryService.deleteCategory(id);
        LOG.info("Successfully deleted category with ID: {}", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(CategoryResponseMessage.CATEGORY_SUCCESSFULLY_DELETED.getMessage(id));
    }
}
