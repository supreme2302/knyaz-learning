package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        users.add(new User(1L, "Egorka", "$2a$10$Ok6KrG0cfm4NAgVs3k01ZeyXPA.4F46QKNioM/6bfW9FmjlTf9ipy"));
        users.add(new User(2L, "Sashka", "$2a$10$fWILrJG/TeqGg/QD8DiFle6QXl5Ay4R5/LFyq8S.oXuQhUtuA5FOO"));

    }

    @Override
    public User findByUsername(String username) {
        for (User foundUser : users) {
            if (foundUser.getUsername().equals(username)) {
                return foundUser;
            }
        }
        return null;
    }


    @Override
    public boolean save(User user) {
        for (User findUser : users) {
            if (findUser.getUsername().equals(user.getUsername())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }
}
