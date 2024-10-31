package com.example.demo.repository;

import com.example.demo.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<Item> findAll();
    Item save(Item item);
    Optional<Item> findById(Long id);
    void deleteById(Long id);
}
