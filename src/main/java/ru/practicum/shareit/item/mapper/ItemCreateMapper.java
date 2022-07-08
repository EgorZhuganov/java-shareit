package ru.practicum.shareit.item.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.dto.ItemCreateDto;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.request.repository.ItemRequestRepository;

@Component
@RequiredArgsConstructor
public class ItemCreateMapper {

    private final ItemRequestRepository itemRequestRepository;

    public Item mapFrom(ItemCreateDto dto) {
        return Item.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .itemRequest(itemRequestRepository.findById(dto.getItemRequestId()).orElse(null))
                .available(true)
                .build();
    }

}
