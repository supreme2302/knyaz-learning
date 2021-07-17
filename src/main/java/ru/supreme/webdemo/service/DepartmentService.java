package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.entity.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAllDepartments();

    DepartmentDTO findDepartmentById(Long id);

    void saveDepartment(DepartmentDTO departmentEntity);

    void deleteDepartment(Long id);

    DepartmentDTO updateDepartment(Long id,
                                   DepartmentDTO departmentEntity);
}
