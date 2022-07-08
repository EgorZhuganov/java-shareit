package ru.practicum.shareit.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.practicum.shareit.item.dto.ItemCreateDto;
import ru.practicum.shareit.item.dto.ItemReadDto;
import ru.practicum.shareit.item.dto.ItemUpdateDto;
import ru.practicum.shareit.item.service.ItemService;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ItemReadDto create(@RequestHeader(value = "X-Sharer-User-Id") Long ownerId,
                              @RequestBody ItemCreateDto dto) {
        try {
            return itemService.create(ownerId, dto);
        } catch (IllegalArgumentException | ConstraintViolationException e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ItemReadDto findById(@PathVariable Long id) {
        return itemService.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(NOT_FOUND, format("Item with id %d not found", id));
        });
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ItemReadDto> findAllByOwnerId(@RequestHeader(value = "X-Sharer-User-Id") Long ownerId) {
        return itemService.findAllByOwnerId(ownerId);
    }

    @PatchMapping
    @ResponseStatus(OK)
    public ItemReadDto update(@RequestHeader(value = "X-Sharer-User-Id") Long ownerId,
                              ItemUpdateDto dto) {
        try {
            return itemService.update(ownerId, dto).orElseThrow(() -> {
                throw new ResponseStatusException(BAD_REQUEST, format("Item with id %d not found for updating", dto.getId()));
            });
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/search")
    @ResponseStatus(OK)
    public List<ItemReadDto> searchAvailableItemByDescription(@RequestParam String text) {
        return itemService.findByAvailableTrueAndDescriptionContainingIgnoreCase(text);
    }
}
