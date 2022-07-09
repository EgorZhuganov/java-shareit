package ru.practicum.shareit.request.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.request.dto.ItemRequestCreateDto;
import ru.practicum.shareit.request.model.ItemRequest;

@Component
public class ItemRequestCreateMapper {

    public ItemRequest mapFrom(ItemRequestCreateDto dto) {
        return ItemRequest.builder()
                .description(dto.getDescription())
                .created(dto.getCreated())
                .build();
    }

}
