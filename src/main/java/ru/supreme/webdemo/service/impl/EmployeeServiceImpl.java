package ru.supreme.webdemo.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;
import ru.supreme.webdemo.repository.impl.EmployeeRepositoryImpl;
import ru.supreme.webdemo.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Обрати внивание, что мы внедряем зависимость через интерфейс EmployeeRepository,
     * а не через его реализацию EmployeeRepositoryImpl
     */
    public EmployeeServiceImpl(@Qualifier("employeeRepositoryImpl") EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }
    @Override
    public void save(EmployeeEntity employeeEntity) {
       employeeRepository.saveEmployee(employeeEntity);
    }
    @Override
    public void delete(Long id) {
        employeeRepository.deleteEmployee(id);
    }
    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }
}