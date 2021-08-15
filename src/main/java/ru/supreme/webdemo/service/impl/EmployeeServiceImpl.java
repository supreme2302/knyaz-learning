package ru.supreme.webdemo.service.impl;

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
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
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
    public EmployeeWithDepartmentIdDTO create(EmployeeWithDepartmentIdDTO employee) {
        EmployeeEntity employeeEntity = employeeRepository.save(employeeMapper.dtoToEntity(employee));
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
    public EmployeeWithDepartmentIdDTO update(Long id, EmployeeWithDepartmentIdDTO employeeDTO) {
        EmployeeEntity newEmployeeEntity = employeeRepository.findEmployeeById(id);
        if (newEmployeeEntity == null) {
            return null;
        } else {
            if (employeeDTO.getPosition() != null) {
                newEmployeeEntity.setPosition(employeeDTO.getPosition());
            }
            if (employeeDTO.getName() != null) {
                newEmployeeEntity.setName(employeeDTO.getName());
            }
            if (employeeDTO.getDepartmentId() != null) {
                newEmployeeEntity.setDepartmentId(employeeDTO.getDepartmentId());
            }
            if (employeeDTO.getSalary() != null) {
                newEmployeeEntity.setSalary(employeeDTO.getSalary());
            }
            EmployeeEntity employee = employeeRepository.update(id, newEmployeeEntity);
            return employeeMapper.entityToEmployeeWithDepartmentIdDTO(employee);
        }
    }
}