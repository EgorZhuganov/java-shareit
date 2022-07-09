package ru.practicum.shareit.request.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.request.dto.ItemRequestReadDto;
import ru.practicum.shareit.request.ItemRequest;

@Component
public class ItemRequestReadMapper {

    public ItemRequestReadDto mapFrom(ItemRequest itemRequest) {
        return ItemRequestReadDto.builder()
                .id(itemRequest.getId())
                .created(itemRequest.getCreated())
                .requesterId(itemRequest.getRequester().getId())
                .description(itemRequest.getDescription())
                .build();
    }

}
