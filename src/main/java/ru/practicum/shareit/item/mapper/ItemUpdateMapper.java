package ru.practicum.shareit.item.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.dto.ItemUpdateDto;
import ru.practicum.shareit.item.Item;

@Component
public class ItemUpdateMapper {

    public Item mapFrom(ItemUpdateDto fromDto, Item toObject) {
        fromDto.getName().ifPresent(toObject::setName);
        fromDto.getDescription().ifPresent(toObject::setDescription);
        fromDto.getAvailable().ifPresent(toObject::setAvailable);
        return toObject;
    }

}
