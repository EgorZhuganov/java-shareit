package ru.practicum.shareit.user.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.dto.UserUpdateDto;
import ru.practicum.shareit.user.model.User;

@Component
public class UserUpdateMapper {

    public User mapFrom(UserUpdateDto fromDto, User toObject) {
        if (fromDto.getEmail() != null)
            toObject.setEmail(fromDto.getEmail());
        if (fromDto.getName() != null)
            toObject.setName(fromDto.getName());
        return toObject;
    }

}
