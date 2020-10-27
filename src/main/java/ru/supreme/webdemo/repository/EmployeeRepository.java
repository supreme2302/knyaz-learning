package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    /**
     * Метод возвращает всех работников
     * @return employeeList
     */
    List<Employee> findAllEmployees();
    public void saveEmployee(Employee employee);
    public void deleteEmployee(Long id);
}
