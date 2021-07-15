package ru.supreme.webdemo.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.dto.EmployeeDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.repository.EmployeeRepository;
import ru.supreme.webdemo.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final DepartmentRepository departmentRepository;

    /**
     * Обрати внивание, что мы внедряем зависимость через интерфейс EmployeeRepository,
     * а не через его реализацию EmployeeRepositoryImpl
     */
    public EmployeeServiceImpl(@Qualifier("employeeRepositoryImpl") EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.saveEmployee(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(id);
        DepartmentEntity departmentEntity = departmentRepository.findDepartmentById(employeeEntity.getDepartmentId());
        return employeeMapper.entityToDTO(employeeEntity, departmentEntity.getDirection());
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity updated = employeeRepository.findEmployeeById(id);
        if (employeeEntity.getPosition() != null) {
            updated.setPosition(employeeEntity.getPosition());
        }
        if (employeeEntity.getName() != null) {
            updated.setName(employeeEntity.getName());
        }
        if (employeeEntity.getDepartmentId() != null) {
            updated.setDepartmentId(employeeEntity.getDepartmentId());
        }
        if (employeeEntity.getSalary() != null) {
            updated.setSalary(employeeEntity.getSalary());
        }
        return employeeRepository.updateEmployee(id, updated);
    }
}