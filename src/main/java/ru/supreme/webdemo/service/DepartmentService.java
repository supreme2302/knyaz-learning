package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentWithoutEmployeeListDTO> findAllDepartments();

    List<DepartmentWithEmployeeListDTO> findAllDepartmentsWithEmployees();

    DepartmentWithEmployeeListDTO findDepartmentById(Long id);

    DepartmentWithEmployeeListDTO create(DepartmentWithEmployeeListDTO departmentDTO);

    void delete(Long id);

    DepartmentWithoutEmployeeListDTO update(Long id, DepartmentWithoutEmployeeListDTO departmentDTO);
}
