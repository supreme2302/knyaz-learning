package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.supreme.webdemo.enums.OperationType;
import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.model.entity.DepartmentAuditEntity;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.repository.DepartmentAuditRepository;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.service.DepartmentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    private final DepartmentAuditRepository departmentAuditRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 DepartmentMapper departmentMapper,
                                 DepartmentAuditRepository departmentAuditRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.departmentAuditRepository = departmentAuditRepository;
    }

    @Override
    public List<DepartmentWithoutEmployeeListDTO> findAllDepartments() {
        return departmentRepository.findAllDepartments().stream()
                .map(departmentMapper::entityToDepartmentWithoutEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentWithEmployeeListDTO> findAllDepartmentsWithEmployees() {
        return departmentRepository.findAllDepartmentsWithEmployees().stream()
                .map(departmentMapper::entityToDepartmentWithEmployeeListDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentWithEmployeeListDTO findDepartmentById(Long id) {
        return departmentMapper.entityToDepartmentWithEmployeeListDTO(departmentRepository.findDepartmentById(id));
    }

    @Override
    @Transactional
    public DepartmentWithEmployeeListDTO create(DepartmentWithEmployeeListDTO departmentDTO, UserDTO userDTO) {
        Long id = departmentRepository.save(departmentMapper.dtoToEntity(departmentDTO));
        DepartmentAuditEntity departmentAudit = new DepartmentAuditEntity(null,
                userDTO.getUsername(),
                id, OperationType.CREATE.getValue(),
                LocalDateTime.now());
        departmentAuditRepository.save(departmentAudit);
        departmentDTO.setId(id);
        return departmentMapper.entityToDepartmentWithEmployeeListDTO(departmentMapper.dtoToEntity(departmentDTO));
    }

    @Override
    @Transactional
    public void delete(Long id, UserDTO userDTO) {
        departmentRepository.delete(id);
        DepartmentAuditEntity departmentAudit = new DepartmentAuditEntity(null,
                userDTO.getUsername(),
                id,
                OperationType.DELETE.getValue(),
                LocalDateTime.now());
        departmentAuditRepository.save(departmentAudit);
    }

    @Override
    @Transactional
    public DepartmentWithoutEmployeeListDTO update(Long id, DepartmentWithoutEmployeeListDTO departmentDTO, UserDTO userDTO) {
        DepartmentEntity newDepartmentEntity = departmentRepository.findDepartmentById(id);
        if (newDepartmentEntity == null) {
            return null;
        } else {
            if (departmentDTO.getDirection() != null) {
                newDepartmentEntity.setDirection(departmentDTO.getDirection());
            }
            if (departmentDTO.getSalaryCoefficient() != null) {
                newDepartmentEntity.setSalaryCoefficient(departmentDTO.getSalaryCoefficient());
            }
            DepartmentAuditEntity departmentAudit = new DepartmentAuditEntity(null,
                    userDTO.getUsername(),
                    id,
                    OperationType.UPDATE.getValue(),
                    LocalDateTime.now());
            departmentAuditRepository.save(departmentAudit);
            return departmentMapper.entityToDepartmentWithoutEmployeeDTO(departmentRepository.update(id, newDepartmentEntity));
        }
    }
}
