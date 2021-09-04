package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.dto.EmployeeAuditDTO;
import ru.supreme.webdemo.repository.EmployeeAuditRepository;
import ru.supreme.webdemo.service.EmployeeAuditService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAuditServiceImpl implements EmployeeAuditService {

    private EmployeeAuditRepository employeeAuditRepository;

    private EmployeeAuditMapper employeeAuditMapper;

    public EmployeeAuditServiceImpl(EmployeeAuditRepository employeeAuditRepository, EmployeeAuditMapper employeeAuditMapper) {
        this.employeeAuditRepository = employeeAuditRepository;
        this.employeeAuditMapper = employeeAuditMapper;
    }

    @Override
    public List<EmployeeAuditDTO> findAllRecords() {
        return employeeAuditRepository.findAllRecords().stream()
                .map(employeeAuditMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
