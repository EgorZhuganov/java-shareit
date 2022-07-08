package ru.practicum.shareit.item.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.dto.ItemUpdateDto;
import ru.practicum.shareit.item.model.Item;

@Component
public class ItemUpdateMapper {

    public Item mapFrom(ItemUpdateDto fromDto, Item toObject) {
        toObject.setAvailable(fromDto.isAvailable());
        toObject.setName(fromDto.getName());
        toObject.setDescription(fromDto.getDescription());
        return toObject;
    }

}
