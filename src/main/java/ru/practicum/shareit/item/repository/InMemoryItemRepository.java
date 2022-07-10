package ru.practicum.shareit.item.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.item.model.Item;

import java.util.*;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class InMemoryItemRepository {

    private final Map<Long, Item> items = new HashMap<>();
    private Long id = 0L;

    public List<Item> findAll() {
        return new ArrayList<>(items.values());
    }

    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(setId());
        }
        items.put(item.getId(), item);
        return item;
    }

    public void delete(Long id) {
        items.remove(id);
    }

    public Optional<Item> findById(Long id) {
        return ofNullable(items.get(id));
    }

    public List<Item> findAllByOwnerId(Long ownerId) {
        var itemsCollections = items.values();
        List<Item> ownerItems = new ArrayList<>();
        for (Item item : itemsCollections) {
            if (item.getOwner().getId().equals(ownerId)) {
                ownerItems.add(item);
            }
        }
        return ownerItems;
    }

    public List<Item> findByAvailableTrueAndDescriptionContainingIgnoreCase(String text) {
        var itemsCollection = items.values();
        List<Item> availableItems = new ArrayList<>();
        for (Item item : itemsCollection) {
            if (item.isAvailable() && item.getDescription().toLowerCase().contains(text.toLowerCase())) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    private Long setId() {
        ++id;
        return id;
    }
}
