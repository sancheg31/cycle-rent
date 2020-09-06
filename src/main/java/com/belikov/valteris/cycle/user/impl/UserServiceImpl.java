package com.belikov.valteris.cycle.user.impl;

import com.belikov.valteris.cycle.user.UserRepository;
import com.belikov.valteris.cycle.user.UserService;
import com.belikov.valteris.cycle.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean register(User user) {
        if(findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
//        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
