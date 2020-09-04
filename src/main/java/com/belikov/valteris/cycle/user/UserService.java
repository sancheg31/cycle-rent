package com.belikov.valteris.cycle.user;

import com.belikov.valteris.cycle.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User newUser) {
        userRepository.save(newUser);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
       return userRepository.findById(id);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
