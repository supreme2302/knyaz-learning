package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.UserEntity;

public interface UserRepository {

    UserEntity findUserByUsername(String username);

    UserEntity save(UserEntity userEntity);
}
