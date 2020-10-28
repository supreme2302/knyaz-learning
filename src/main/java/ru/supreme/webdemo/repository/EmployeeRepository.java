package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    /**
     * Метод возвращает всех работников
     * @return employeeList
     */
    List<Employee> findAllEmployees();
    void saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
}
