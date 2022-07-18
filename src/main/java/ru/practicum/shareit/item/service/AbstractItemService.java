package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemCreateDto;
import ru.practicum.shareit.item.dto.ItemReadDto;
import ru.practicum.shareit.item.dto.ItemUpdateDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface AbstractItemService {

    ItemReadDto create(@NotNull Long ownerId, @Valid ItemCreateDto dto);

    Optional<ItemReadDto> findById(Long id);

    List<ItemReadDto> findAllByOwnerId(Long ownerId);

    Optional<ItemReadDto> update(@NotNull Long ownerId, Long id, @Valid ItemUpdateDto dto);

    List<ItemReadDto> findByAvailableTrueAndDescriptionContainingIgnoreCase(String text);

    Optional<ItemReadDto> delete(@NotNull Long ownerId, Long id);

}
