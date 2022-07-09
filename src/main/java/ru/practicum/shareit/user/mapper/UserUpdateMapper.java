package ru.practicum.shareit.user.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.dto.UserUpdateDto;
import ru.practicum.shareit.user.User;

@Component
public class UserUpdateMapper {

    public User mapFrom(UserUpdateDto fromDto, User toObject) {
        fromDto.getName().ifPresent(toObject::setName);
        fromDto.getEmail().ifPresent(toObject::setEmail);
        return toObject;
    }

}
