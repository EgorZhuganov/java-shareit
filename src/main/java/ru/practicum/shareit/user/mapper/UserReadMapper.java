package ru.practicum.shareit.user.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.dto.UserReadDto;
import ru.practicum.shareit.user.User;

@Component
public class UserReadMapper {

    public UserReadDto mapFrom(User user) {
        return UserReadDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
