package com.belikov.valteris.cycle.user;

import com.belikov.valteris.cycle.user.model.User;
import com.belikov.valteris.cycle.user.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    List<User> getAll();

    Optional<User> getById(Long id);

    void delete(Long id);

    boolean register(UserDTO userDTO);

    Optional<User> findByUsername(String username);
}