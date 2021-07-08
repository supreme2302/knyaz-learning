package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    List<DepartmentWithoutEmployeeListDTO> findAllDepartments();

    List<DepartmentWithEmployeeListDTO> findAllDepartmentsWithEmployees();

    DepartmentWithEmployeeListDTO findDepartmentById(Long id);

    DepartmentWithoutEmployeeListDTO create(DepartmentEntity departmentEntity);

    void delete(Long id);

    DepartmentWithoutEmployeeListDTO update(Long id, DepartmentEntity departmentEntity);
}
