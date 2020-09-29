package com.belikov.valteris.cycle.user.impl;

import com.belikov.valteris.cycle.config.Mapper;
import com.belikov.valteris.cycle.user.UserRepository;
import com.belikov.valteris.cycle.user.UserService;
import com.belikov.valteris.cycle.user.model.Role;
import com.belikov.valteris.cycle.user.model.User;
import com.belikov.valteris.cycle.user.model.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper<UserDTO, User> userMapper;
//    private final PasswordEncoder encoder;

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
    public boolean register(UserDTO userDTO) {
//        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
//        final User user = userMapper.mapDomainToEntity(userDTO);
//        user.setRole(Role.USER);
//        user.setOrders(new ArrayList<>());
//        userRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> findByUsername (String username) {
        return userRepository.findByUsername(username);
    }
}
