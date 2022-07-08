package ru.practicum.shareit.request.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Getter
@Builder
public class ItemRequestReadDto {

    Long id;
    String description;
    LocalDateTime created;
    Long requesterId;

}
