package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.User;

public interface UserRepository {
    User findByUsername(String username);
    boolean save(User user);
}
