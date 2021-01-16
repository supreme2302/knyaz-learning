package ru.supreme.webdemo.service.impl;

import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.repository.UserRepository;
import ru.supreme.webdemo.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkoutAuth(User user) {
        if (userRepository.checkoutAuthRepository(user) == true)
            return true;
        return false;
    }

    @Override
    public boolean registration(User user) {
        if (userRepository.registrUser(user)) {
            return false;
        }
        return true;
    }
}
