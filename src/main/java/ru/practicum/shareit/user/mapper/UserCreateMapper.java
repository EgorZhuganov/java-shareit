package ru.practicum.shareit.user.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.dto.UserCreateDto;
import ru.practicum.shareit.user.User;

import java.util.ArrayList;

@Component
public class UserCreateMapper {

    public User mapFrom(UserCreateDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .bookings(new ArrayList<>())
                .comments(new ArrayList<>())
                .items(new ArrayList<>())
                .requests(new ArrayList<>())
                .build();
    }

}
