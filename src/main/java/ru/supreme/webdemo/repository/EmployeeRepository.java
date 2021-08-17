package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {

    /**
     * Метод возвращает всех работников
     *
     * @return employeeList
     */

    List<EmployeeEntity> findAllEmployees();

    Long save(EmployeeEntity employeeEntity);

    void delete(Long id);

    EmployeeEntity findEmployeeById(Long id);

    EmployeeEntity update(Long id, EmployeeEntity employeeEntity);
}
