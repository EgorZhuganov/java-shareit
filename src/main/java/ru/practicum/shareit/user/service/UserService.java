package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.practicum.shareit.user.dto.UserCreateDto;
import ru.practicum.shareit.user.dto.UserReadDto;
import ru.practicum.shareit.user.dto.UserUpdateDto;
import ru.practicum.shareit.user.mapper.UserCreateMapper;
import ru.practicum.shareit.user.mapper.UserReadMapper;
import ru.practicum.shareit.user.mapper.UserUpdateMapper;
import ru.practicum.shareit.user.repository.UserRepository;
import ru.practicum.shareit.user.validation.UserValidator;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class UserService implements AbstractUserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserReadMapper userReadMapper;
    private final UserUpdateMapper userUpdateMapper;
    private final UserValidator userValidator;


    public UserReadDto create(@Valid UserCreateDto dto) {
        userValidator.isValid(dto.getEmail());
        return of(dto)
                .map(userCreateMapper::mapFrom)
                .map(userRepository::save)
                .map(userReadMapper::mapFrom)
                .orElseThrow();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository
                .findById(id)
                .map(userReadMapper::mapFrom);
    }

    public List<UserReadDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userReadMapper::mapFrom)
                .collect(toList());
    }

    public Optional<UserReadDto> update(Long id, @Valid UserUpdateDto dto) {
        userValidator.isValid(dto.getEmail());

        return userRepository.findById(id)
                .map(user -> userUpdateMapper.mapFrom(dto, user))
                .map(userRepository::save)
                .map(userReadMapper::mapFrom);
    }

    public boolean delete(Long id) {
        return userRepository
                .findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                })
                .orElse(false);
    }
}
