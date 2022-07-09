package ru.practicum.shareit.request.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.request.dto.ItemRequestUpdateDto;
import ru.practicum.shareit.request.ItemRequest;

@Component
public class ItemRequestUpdateMapper {

    public ItemRequest mapFrom(ItemRequestUpdateDto fromDto, ItemRequest toObject) {
        toObject.setCreated(fromDto.getCreated());
        toObject.setDescription(fromDto.getDescription());
        return toObject;
    }

}
