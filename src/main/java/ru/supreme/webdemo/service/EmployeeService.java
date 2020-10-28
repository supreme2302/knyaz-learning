package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void save(Employee employee);
    void delete(Long id);

    Employee getEmployeeById(Long id);
}