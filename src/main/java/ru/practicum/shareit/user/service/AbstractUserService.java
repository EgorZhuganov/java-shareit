package ru.practicum.shareit.user.service;

import ru.practicum.shareit.user.dto.UserCreateDto;
import ru.practicum.shareit.user.dto.UserReadDto;
import ru.practicum.shareit.user.dto.UserUpdateDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface AbstractUserService {

    UserReadDto create(@Valid UserCreateDto dto);

    Optional<UserReadDto> findById(Long id);

    List<UserReadDto> findAll();

    Optional<UserReadDto> update(Long id, @Valid UserUpdateDto dto);

    boolean delete(Long id);

}
