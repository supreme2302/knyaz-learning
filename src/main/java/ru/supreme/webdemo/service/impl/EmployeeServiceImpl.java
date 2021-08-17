package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.supreme.webdemo.enums.OperationType;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeAuditEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.repository.EmployeeAuditRepository;
import ru.supreme.webdemo.repository.EmployeeRepository;
import ru.supreme.webdemo.service.EmployeeService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final DepartmentRepository departmentRepository;

    private final EmployeeAuditRepository employeeAuditRepository;

    /**
     * Обрати внивание, что мы внедряем зависимость через интерфейс EmployeeRepository,
     * а не через его реализацию EmployeeRepositoryImpl
     */
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               EmployeeMapper employeeMapper,
                               EmployeeAuditRepository employeeAuditRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
        this.employeeAuditRepository = employeeAuditRepository;
    }

    @Override
    public List<EmployeeWithDepartmentNameDTO> findAllEmployees() {
        return employeeRepository.findAllEmployees().stream()
                .map(employeeEntity -> employeeMapper.entityToEmployeeWithDepartmentNameDTO(employeeEntity,
                        departmentRepository.findDepartmentById(employeeEntity.getDepartmentId()).getDirection()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeWithDepartmentIdDTO create(EmployeeWithDepartmentIdDTO employee, UserDTO userDTO) {
        Long id = employeeRepository.save(employeeMapper.dtoToEntity(employee));
        /**null на id - это как заглушка
         */
        EmployeeAuditEntity employeeAudit = new EmployeeAuditEntity(null,
                userDTO.getUsername(),
                id,
                OperationType.CREATE.getValue(),
                LocalDateTime.now());
        employeeAuditRepository.save(employeeAudit);
        /**сделал такую обертку, чтобы можно было передать id в респонс от контроллера. до этого id возвращался null
         */
        employee.setId(id);
        return employeeMapper.entityToEmployeeWithDepartmentIdDTO(employeeMapper.dtoToEntity(employee));
    }

    @Override
    @Transactional
    public void delete(Long id, UserDTO userDTO) {
        employeeRepository.delete(id);
        EmployeeAuditEntity employeeAudit = new EmployeeAuditEntity(null,
                userDTO.getUsername(),
                id,
                OperationType.DELETE.getValue(),
                LocalDateTime.now());
        employeeAuditRepository.save(employeeAudit);
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
    @Transactional
    public EmployeeWithDepartmentIdDTO update(Long id, EmployeeWithDepartmentIdDTO employeeDTO, UserDTO userDTO) {
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
            EmployeeAuditEntity employeeAudit = new EmployeeAuditEntity(null,
                    userDTO.getUsername(),
                    id,
                    OperationType.UPDATE.getValue(),
                    LocalDateTime.now());
            employeeAuditRepository.save(employeeAudit);
            return employeeMapper.entityToEmployeeWithDepartmentIdDTO(employee);
        }
    }
}