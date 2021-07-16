package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    List<DepartmentEntity> findAllDepartments();

    DepartmentEntity findDepartmentById(Long id);

    void saveDepartment(DepartmentEntity departmentEntity);
}
