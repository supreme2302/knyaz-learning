package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final List<DepartmentEntity> departmentEntities = new ArrayList<>();

    @Override
    public List<DepartmentEntity> findAllDepartments() {
        return departmentEntities;
    }

    @Override
    public DepartmentEntity findDepartmentById(Long id) {
        for (DepartmentEntity departmentEntity : departmentEntities) {
            if (departmentEntity.getId().equals(id)) {
                return departmentEntity;
            }
        }
        return null;
    }
}
