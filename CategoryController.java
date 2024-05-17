package com.categoryapi.category.controller;

import com.categoryapi.category.model.Category;
import com.categoryapi.category.model.Item;
import com.categoryapi.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @PostMapping("/{categoryId}/items")
    public ResponseEntity<Item> addItemToCategory(@PathVariable Long categoryId, @RequestBody Item item) {
        Item createdItem = categoryService.addItemToCategory(categoryId, item);
        return ResponseEntity.ok(createdItem);
    }

    @PutMapping("/{categoryId}/items/{itemId}")
    public ResponseEntity<Item> updateItemCountInCategory(@PathVariable Long categoryId, @PathVariable Long itemId, @RequestBody Item item) {
        Item updatedItem = categoryService.updateItemCountInCategory(categoryId, itemId, item.getCount());
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategoryName(@PathVariable Long categoryId, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategoryName(categoryId, category.getName());
        return ResponseEntity.ok(updatedCategory);
    }
}

