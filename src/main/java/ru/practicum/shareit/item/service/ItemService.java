package ru.practicum.shareit.item.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.practicum.shareit.item.dto.ItemCreateDto;
import ru.practicum.shareit.item.dto.ItemReadDto;
import ru.practicum.shareit.item.dto.ItemUpdateDto;
import ru.practicum.shareit.item.mapper.ItemCreateMapper;
import ru.practicum.shareit.item.mapper.ItemReadMapper;
import ru.practicum.shareit.item.mapper.ItemUpdateMapper;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.user.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class ItemService implements AbstractItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ItemCreateMapper itemCreateMapper;
    private final ItemReadMapper itemReadMapper;
    private final ItemUpdateMapper itemUpdateMapper;

    @Override
    public ItemReadDto create(@NotNull Long ownerId, @Valid ItemCreateDto dto) {
        var maybeUser = userRepository.findById(ownerId);
        if (maybeUser.isEmpty()) {
            log.warn("User with id {} not found for create new item", ownerId);
            throw new IllegalArgumentException(format("User with id %d not found for create new item", ownerId));
        }

        return of(itemCreateMapper.mapFrom(dto))
                .map(item -> {
                    item.setOwner(maybeUser.get());
                    return itemRepository.save(item);
                })
                .map(itemReadMapper::mapFrom)
                .orElseThrow();
    }

    @Override
    public Optional<ItemReadDto> findById(Long id) {
        return itemRepository.findById(id)
                .map(itemReadMapper::mapFrom);
    }

    @Override
    public List<ItemReadDto> findAllByOwnerId(Long ownerId) {
        return itemRepository.findAllByOwnerId(ownerId)
                .stream()
                .map(itemReadMapper::mapFrom)
                .collect(toList());
    }

    @Override
    public Optional<ItemReadDto> update(@NotNull Long ownerId, @Valid ItemUpdateDto dto) {
        var maybeItem = itemRepository.findById(dto.getId());
        if (maybeItem.isPresent() && !maybeItem.get().getOwner().getId().equals(ownerId)) {
            log.warn("Trying change item with id {} by user with id {} which not owner", dto.getId(), ownerId);
            throw new UnsupportedOperationException(
                    format("Trying change item with id %d by user with id %d which not owner", dto.getId(), ownerId));
        }
        return maybeItem
                .map(item -> itemUpdateMapper.mapFrom(dto, item))
                .map(itemRepository::save)
                .map(itemReadMapper::mapFrom);
    }

    @Override
    public List<ItemReadDto> findByAvailableTrueAndDescriptionContainingIgnoreCase(String text) {
        return itemRepository.findByAvailableTrueAndDescriptionContainingIgnoreCase(text).stream()
                .map(itemReadMapper::mapFrom)
                .collect(toList());
    }
}
