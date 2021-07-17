package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.entity.DepartmentDTO;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<DepartmentDTO> findAllDepartments() {
        return departmentRepository.findAllDepartments();
    }

    @Override
    public DepartmentDTO findDepartmentById(Long id) {
        DepartmentDTO departmentEntity = departmentRepository.findDepartmentById(id);
        return departmentMapper.entityToDTO(departmentEntity);
    }

    @Override
    public void saveDepartment(DepartmentDTO departmentEntity) {
        departmentRepository.saveDepartment(departmentEntity);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteDepartment(id);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentEntity) {
        DepartmentDTO updated = departmentRepository.findDepartmentById(id);
        if (departmentEntity.getDirection() != null)
        {
            updated.setDirection(departmentEntity.getDirection());
        }
        if (departmentEntity.getSalaryCoefficient() != null)
        {
            updated.setSalaryCoefficient(departmentEntity.getSalaryCoefficient());
        }
        return departmentRepository.updateDepartment(id, updated);
    }


}
