package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentRepository {



    List<DepartmentEntity> findAllDepartments();

    void saveDepartment(DepartmentEntity departmentEntity);
    void deleteDepartment(Long id);

    DepartmentEntity findDepartmentById(Long id);
}
