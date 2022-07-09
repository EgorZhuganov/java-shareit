package ru.practicum.shareit.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.practicum.shareit.user.dto.UserCreateDto;
import ru.practicum.shareit.user.dto.UserReadDto;
import ru.practicum.shareit.user.dto.UserUpdateDto;
import ru.practicum.shareit.user.service.UserService;

import javax.validation.ConstraintViolationException;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    public UserReadDto create(@RequestBody UserCreateDto dto) {
        try {
            return userService.create(dto);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(CONFLICT, e.getMessage());
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserReadDto findById(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> {
            log.warn("User with id {} not found", id);
            throw new ResponseStatusException(NOT_FOUND, format("User with id %d not found", id));
        });
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<UserReadDto> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public UserReadDto update(@PathVariable Long id,
                              @RequestBody UserUpdateDto dto) {
        try {
            return userService.update(id, dto).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        } catch (ConstraintViolationException e) {
            log.warn(e.getMessage());
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK) //TODO изменить на NO_CONTENT или исправить тест
    public void delete(@PathVariable Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
}
