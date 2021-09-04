package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.dto.DepartmentAuditDTO;
import ru.supreme.webdemo.repository.DepartmentAuditRepository;
import ru.supreme.webdemo.service.DepartmentAuditService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentAuditServiceImpl implements DepartmentAuditService {

    private final DepartmentAuditMapper departmentAuditMapper;

    private final DepartmentAuditRepository departmentAuditRepository;

    public DepartmentAuditServiceImpl(DepartmentAuditMapper departmentAuditMapper, DepartmentAuditRepository departmentAuditRepository) {
        this.departmentAuditMapper = departmentAuditMapper;
        this.departmentAuditRepository = departmentAuditRepository;
    }

    @Override
    public List<DepartmentAuditDTO> findAllRecords() {
        return departmentAuditRepository.findAllRecords().stream()
                .map(departmentAuditMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
