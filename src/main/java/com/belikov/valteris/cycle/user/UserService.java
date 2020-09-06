package com.belikov.valteris.cycle.user;

import com.belikov.valteris.cycle.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    List<User> getAll();

    Optional<User> getById(Long id);

    void delete(Long id);

    boolean register(User user);

    Optional<User> findByEmail(String email);
}