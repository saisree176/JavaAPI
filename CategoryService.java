package com.categoryapi.category.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.categoryapi.category.model.Category;
import com.categoryapi.category.model.Item;
import com.categoryapi.category.repository.CategoryRepository;
import com.categoryapi.category.repository.ItemRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Item addItemToCategory(Long categoryId, Item item) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            item.setCategory(category);
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public Item updateItemCountInCategory(Long categoryId, Long itemId, int count) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            if (item.getCategory().getId().equals(categoryId)) {
                item.setCount(count);
                return itemRepository.save(item);
            } else {
                throw new RuntimeException("Item does not belong to the category");
            }
        } else {
            throw new RuntimeException("Item not found");
        }
    }

    public void deleteCategory(Long categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public Category updateCategoryName(Long categoryId, String name) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(name);
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found");
        }
    }
}
