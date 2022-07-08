package ru.practicum.shareit.item.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.dto.ItemReadDto;
import ru.practicum.shareit.item.model.Item;

@Component
public class ItemReadMapper {

    public ItemReadDto mapFrom(Item item) {
        return ItemReadDto.builder()
                .name(item.getName())
                .description(item.getDescription())
                .available(item.isAvailable())
                .itemRequestId(item.getItemRequest().getId())
                .ownerId(item.getOwner().getId())
                .build();
    }

}
