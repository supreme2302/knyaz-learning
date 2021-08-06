package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.UserDTO;

public interface UserService {

    boolean checkAuth(UserDTO userDTO);

    UserDTO registration(UserDTO userDTO);
}
