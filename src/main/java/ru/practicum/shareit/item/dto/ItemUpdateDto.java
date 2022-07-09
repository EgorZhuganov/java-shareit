package ru.practicum.shareit.item.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = PRIVATE)
public class ItemUpdateDto {

    Optional<String> name;
    Optional<String> description;
    Optional<Boolean> available;

}
