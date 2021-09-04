package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.EmployeeAuditDTO;
import ru.supreme.webdemo.model.entity.EmployeeAuditEntity;

@Component
public class EmployeeAuditMapper {

    public EmployeeAuditDTO entityToDto(EmployeeAuditEntity employeeAudit) {
        if (employeeAudit == null) {
            return null;
        } else {
            return new EmployeeAuditDTO(employeeAudit.getId(),
                    employeeAudit.getPerformer(),
                    employeeAudit.getEmployeeId(),
                    employeeAudit.getOperationType(),
                    employeeAudit.getOperationDate());
        }
    }

    public EmployeeAuditEntity dtoToEntity(EmployeeAuditDTO employeeAuditDTO) {
        if (employeeAuditDTO == null) {
            return null;
        } else {
            return new EmployeeAuditEntity(employeeAuditDTO.getId(),
                    employeeAuditDTO.getPerformer(),
                    employeeAuditDTO.getEmployeeId(),
                    employeeAuditDTO.getOperationType(),
                    employeeAuditDTO.getOperationDate());
        }
    }
}
