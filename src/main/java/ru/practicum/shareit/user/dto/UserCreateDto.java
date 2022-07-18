package ru.practicum.shareit.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
@Getter
@Builder
public class UserCreateDto {

    @NotBlank
    String name;
    @Email @NotBlank
    String email;

}
