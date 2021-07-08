package ru.supreme.webdemo.service.impl;

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
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
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
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getEmployeeById(id);
        DepartmentEntity departmentEntity = departmentRepository.findById(employeeEntity.getDepartmentId());
        return employeeMapper.entityToDTO(employeeEntity, departmentEntity.getName());
    }
}