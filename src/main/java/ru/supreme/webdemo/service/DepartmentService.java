package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.entity.DepartmentEntity;

public interface DepartmentService {

    DepartmentEntity getDepartmentById(Long id);
}