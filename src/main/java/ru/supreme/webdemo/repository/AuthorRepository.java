package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.AuthorEntity;

import java.util.List;

public interface AuthorRepository {

    List<AuthorEntity> findAll();

    AuthorEntity findById(Long id);

    void save(AuthorEntity employeeEntity);

    void delete(Long id);
}
