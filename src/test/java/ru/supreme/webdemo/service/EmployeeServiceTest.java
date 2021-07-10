package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;
import ru.supreme.webdemo.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {

    private final EmployeeRepositoryTest employeeRepositoryTest = new EmployeeRepositoryTest();

    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepositoryTest);


    private static class EmployeeRepositoryTest implements EmployeeRepository {
        @Override
        public List<EmployeeEntity> findAllEmployees() {
            return new ArrayList<>();
        }

        @Override
        public void saveEmployee(EmployeeEntity employeeEntity) {

        }

        @Override
        public void deleteEmployee(Long id) {

        }

        @Override
        public EmployeeEntity getEmployeeById(Long id) {
            return null;
        }
    }
}
