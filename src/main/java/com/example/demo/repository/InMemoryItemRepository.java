package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryItemRepository implements ItemRepository {
    private List<Item> items = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(currentId++);
        }
        items.removeIf(existingItem -> existingItem.getId().equals(item.getId()));
        items.add(item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        items.removeIf(item -> item.getId().equals(id));
    }
}
