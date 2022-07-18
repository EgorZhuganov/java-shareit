package ru.practicum.shareit.request.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
@Getter
@Builder
public class ItemRequestCreateDto {

    @NotBlank
    String description;
    @NotNull
    LocalDateTime created;

}
