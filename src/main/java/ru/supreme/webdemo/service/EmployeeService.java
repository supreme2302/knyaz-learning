package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.EmployeeDTO;
import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> findAllEmployees();

    void saveEmployee(EmployeeEntity employeeEntity);

    void deleteEmployee(Long id);

    EmployeeDTO findEmployeeById(Long id);

    EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity);
}