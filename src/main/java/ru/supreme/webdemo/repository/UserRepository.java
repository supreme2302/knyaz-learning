package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.User;

public interface UserRepository {
    boolean checkoutAuthRepository(User user);
    boolean registrUser(User user);
}
