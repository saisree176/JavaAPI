package com.categoryapi.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.categoryapi.category.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
