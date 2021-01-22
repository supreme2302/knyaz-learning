package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    boolean checkAuth(User user);
    boolean registration(User user);
}
