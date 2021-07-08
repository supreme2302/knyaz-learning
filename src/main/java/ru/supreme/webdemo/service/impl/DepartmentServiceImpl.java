package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
}
