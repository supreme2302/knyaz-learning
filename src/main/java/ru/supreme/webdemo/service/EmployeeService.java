package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    public void save(Employee employee);
    public void delete(Long id);

    public Employee getIdEmployee(Long id);
}