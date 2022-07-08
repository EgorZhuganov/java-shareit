package ru.practicum.shareit.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@Getter
@Builder
public class ItemCreateDto {

    @NotBlank
    String name;
    @NotBlank
    String description;
    Long itemRequestId;

}
