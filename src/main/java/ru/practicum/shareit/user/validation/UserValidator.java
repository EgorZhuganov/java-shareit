package ru.practicum.shareit.user.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.shareit.user.repository.InMemoryUserRepository;

import static java.lang.String.format;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserValidator {

    private final InMemoryUserRepository userRepository; //TODO изменить на UserRepository при добавлении БД

    @Transactional(readOnly = true)
    public boolean isValid(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            log.warn("User with email {} already exist", email);
            throw new IllegalArgumentException(format("User with email %s already exist", email));
        }
        return true;
    }

}
