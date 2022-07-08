package ru.practicum.shareit.request.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = PRIVATE)
public class ItemRequestUpdateDto {

    Long id;
    String description;
    LocalDateTime created;

}
