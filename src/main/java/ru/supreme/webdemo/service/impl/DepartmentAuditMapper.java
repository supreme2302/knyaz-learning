package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.DepartmentAuditDTO;
import ru.supreme.webdemo.model.entity.DepartmentAuditEntity;

@Component
public class DepartmentAuditMapper {

    public DepartmentAuditDTO entityToDto(DepartmentAuditEntity departmentAudit) {
        if (departmentAudit == null) {
            return null;
        } else {
            return new DepartmentAuditDTO(departmentAudit.getId(),
                    departmentAudit.getPerformer(),
                    departmentAudit.getDepartmentId(),
                    departmentAudit.getOperationType(),
                    departmentAudit.getOperationDate());
        }
    }

    public DepartmentAuditEntity dtoToEntity(DepartmentAuditDTO departmentAuditDTO) {
        if (departmentAuditDTO == null) {
            return null;
        } else {
            return new DepartmentAuditEntity(departmentAuditDTO.getId(),
                    departmentAuditDTO.getPerformer(),
                    departmentAuditDTO.getDepartmentId(),
                    departmentAuditDTO.getOperationType(),
                    departmentAuditDTO.getOperationDate());
        }
    }
}
