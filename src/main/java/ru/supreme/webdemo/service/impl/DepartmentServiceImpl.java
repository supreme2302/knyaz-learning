package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentEntity findDepartmentById(Long id) {
        return departmentRepository.findDepartmentInfoByDepartmentId(id);
    }

    @Override
    public void saveDepartment(DepartmentEntity departmentEntity) {
        departmentRepository.saveDepartment(departmentEntity);
    }
}
