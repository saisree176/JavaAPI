package com.categoryapi.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.categoryapi.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
