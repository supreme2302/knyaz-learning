package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {

    /**
     * Метод возвращает всех работников
     * @return employeeList
     */
    List<EmployeeEntity> findAllEmployees();

    void saveEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);

    EmployeeEntity getEmployeeById(Long id);
}
