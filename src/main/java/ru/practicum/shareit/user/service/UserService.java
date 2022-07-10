package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.practicum.shareit.user.dto.UserCreateDto;
import ru.practicum.shareit.user.dto.UserReadDto;
import ru.practicum.shareit.user.dto.UserUpdateDto;
import ru.practicum.shareit.user.mapper.UserCreateMapper;
import ru.practicum.shareit.user.mapper.UserReadMapper;
import ru.practicum.shareit.user.mapper.UserUpdateMapper;
import ru.practicum.shareit.user.repository.InMemoryUserRepository;
import ru.practicum.shareit.user.validation.UserValidator;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class UserService implements AbstractUserService {

    private final InMemoryUserRepository userRepository; //TODO изменить на UserRepository с переходом на БД
    private final UserCreateMapper userCreateMapper;
    private final UserReadMapper userReadMapper;
    private final UserUpdateMapper userUpdateMapper;
    private final UserValidator userValidator;

    @Transactional
    @Override
    public UserReadDto create(@Valid UserCreateDto dto) {
        userValidator.isValid(dto.getEmail());
        return of(dto)
                .map(userCreateMapper::mapFrom)
                .map(userRepository::save)
                .map(userReadMapper::mapFrom)
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserReadDto> findById(Long id) {
        return userRepository
                .findById(id)
                .map(userReadMapper::mapFrom);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserReadDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userReadMapper::mapFrom)
                .collect(toList());
    }

    @Transactional
    @Override
    public Optional<UserReadDto> update(Long id, @Valid UserUpdateDto dto) {
        dto.getEmail().ifPresent(userValidator::isValid);

        return userRepository
                .findById(id)
                .map(user -> userUpdateMapper.mapFrom(dto, user))
                .map(userRepository::save)
                .map(userReadMapper::mapFrom);
    }

    @Transactional
    @Override
    public Optional<UserReadDto> delete(Long id) {
        return userRepository
                .findById(id)
                .map(user -> {
                    userRepository.delete(user.getId()); //TODO изменить на userRepository.delete(user); с переходом на БД
                    return user;
                })
                .map(userReadMapper::mapFrom);
    }
}
