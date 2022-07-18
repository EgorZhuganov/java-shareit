package ru.practicum.shareit.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.practicum.shareit.user.model.User;

import java.util.*;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class InMemoryUserRepository {

    private final Map<Long, User> users = new HashMap<>();
    private Long id = 0L;

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(setId());
        }
        users.put(user.getId(), user);
        return user;
    }

    public void delete(Long id) {
        users.remove(id);
    }

    public Optional<User> findById(Long id) {
        return ofNullable(users.get(id));
    }

    public Optional<User> findByEmail(String email) {
        var userCollection = users.values();
        User searchedUser = null;
        for (User user : userCollection) {
            if (user.getEmail().equals(email)) {
                searchedUser = user;
            }
        }
        return Optional.ofNullable(searchedUser);
    }

    private Long setId() {
        ++id;
        return id;
    }

}
