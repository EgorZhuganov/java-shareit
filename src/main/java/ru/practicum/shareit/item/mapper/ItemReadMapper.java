package ru.practicum.shareit.item.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.dto.ItemReadDto;
import ru.practicum.shareit.item.model.Item;

@Component
public class ItemReadMapper {

    public ItemReadDto mapFrom(Item item) {
        var dto =  ItemReadDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .available(item.isAvailable())
                .ownerId(item.getOwner().getId());
        if (item.getItemRequest() != null)
           dto.itemRequestId(item.getItemRequest().getId());

        return dto.build();
    }

}