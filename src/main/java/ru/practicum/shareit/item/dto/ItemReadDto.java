package ru.practicum.shareit.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@Builder
public class ItemReadDto {

    Long id;
    String name;
    String description;
    boolean available;
    Long ownerId;
    Long itemRequestId;

}
