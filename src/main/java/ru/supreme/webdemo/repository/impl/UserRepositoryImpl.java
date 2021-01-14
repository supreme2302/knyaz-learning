package ru.supreme.webdemo.repository.impl;

import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        users.add(new User(1L, "Egorka", "2302"));
        users.add(new User(2L, "Sashka", "2009"));
    }

    @Override
    public boolean checkoutAuthRepository(User user) {
        for (User findUserPassword : users) {
            if (findUserPassword.getUsername().equals(user.getUsername())) {
                if (findUserPassword.getPassword().equals(user.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
