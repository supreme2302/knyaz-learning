package ru.supreme.webdemo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.repository.UserRepository;
import ru.supreme.webdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean checkAuth(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        return passwordEncoder.matches(user.getPassword(), userFromDB.getPassword());
    }

    @Override
    public boolean registration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

