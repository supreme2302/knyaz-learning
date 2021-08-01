package ru.supreme.webdemo.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.repository.EmployeeRepository;
import ru.supreme.webdemo.service.EmployeeService;

import java.util.ArrayList;
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
    public List<EmployeeWithDepartmentNameDTO> findAllEmployees() {
        List<EmployeeWithDepartmentNameDTO> employeeDTOList = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAllEmployees();
        for (EmployeeEntity employee : employeeEntityList) {
            DepartmentEntity departmentEntity = departmentRepository.findDepartmentById(employee.getDepartmentId());
            EmployeeWithDepartmentNameDTO employeeDTO = employeeMapper.entityToEmployeeWithDepartmentNameDTO(employee, departmentEntity.getDirection());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeWithDepartmentIdDTO create(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
        return employeeMapper.entityToEmployeeWithDepartmentIdDTO(employeeEntity);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public EmployeeWithDepartmentNameDTO findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(id);
        if (employeeEntity == null) {
            return null;
        }
        DepartmentEntity departmentEntity = departmentRepository.findDepartmentById(employeeEntity.getDepartmentId());
        return employeeMapper.entityToEmployeeWithDepartmentNameDTO(employeeEntity, departmentEntity.getDirection());
    }

    @Override
    public List<EmployeeWithDepartmentNameDTO> findEmployeesByDepartmentId(Long id) {
        List<EmployeeWithDepartmentNameDTO> employeeDTOList = new ArrayList<>();
        DepartmentEntity departmentEntity = departmentRepository.findDepartmentById(id);
        if (departmentEntity == null) {
            return null;
        }
        if (departmentEntity.getEmployees() != null) {
            List<EmployeeEntity> employeeEntityList = departmentEntity.getEmployees();
            for (EmployeeEntity employeeEntity : employeeEntityList) {
                EmployeeWithDepartmentNameDTO employeeDTO = employeeMapper.entityToEmployeeWithDepartmentNameDTO(employeeEntity,
                        departmentEntity.getDirection());
                employeeDTOList.add(employeeDTO);
            }
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeWithDepartmentIdDTO update(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity newEmployeeEntity = employeeRepository.findEmployeeById(id);
        if (newEmployeeEntity == null) {
            return null;
        } else {
            if (employeeEntity.getPosition() != null) {
                newEmployeeEntity.setPosition(employeeEntity.getPosition());
            }
            if (employeeEntity.getName() != null) {
                newEmployeeEntity.setName(employeeEntity.getName());
            }
            if (employeeEntity.getDepartmentId() != null) {
                newEmployeeEntity.setDepartmentId(employeeEntity.getDepartmentId());
            }
            if (employeeEntity.getSalary() != null) {
                newEmployeeEntity.setSalary(employeeEntity.getSalary());
            }
            EmployeeEntity employee = employeeRepository.update(id, newEmployeeEntity);
            return employeeMapper.entityToEmployeeWithDepartmentIdDTO(employee);
        }
    }
}