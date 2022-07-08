package ru.practicum.shareit.item.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = PRIVATE)
public class ItemUpdateDto {

    @NotNull
    Long id;
    @NotNull
    String name;
    @NotNull
    String description;
    boolean available;

}
