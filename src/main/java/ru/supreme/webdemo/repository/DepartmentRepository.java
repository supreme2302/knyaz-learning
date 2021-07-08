package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentRepository {

    List<DepartmentEntity> findAll();

    DepartmentEntity findById(Long id);
}
