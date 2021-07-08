package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> getAllEmployees();
    void save(EmployeeEntity employeeEntity);
    void delete(Long id);

    EmployeeDTO getEmployeeById(Long id);

    EmployeeEntity update(Long id, EmployeeEntity employee);
}