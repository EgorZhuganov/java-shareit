package ru.practicum.shareit.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Value
@Getter
@Builder
public class ItemCreateDto {

    @NotBlank
    String name;
    @NotBlank
    String description;
    Optional<Long> itemRequestId;
    @NotNull
    Boolean available;

}
