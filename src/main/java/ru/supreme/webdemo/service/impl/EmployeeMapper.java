package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import ru.supreme.webdemo.model.entity.EmployeeEntity;

@Component
public class EmployeeMapper {

    public EmployeeWithDepartmentNameDTO entityToEmployeeWithDepartmentNameDTO(EmployeeEntity employeeEntity, String departmentName) {
        if (employeeEntity == null) {
            return null;
        } else {
            return new EmployeeWithDepartmentNameDTO(employeeEntity.getId(),
                    employeeEntity.getName(),
                    employeeEntity.getPosition(),
                    employeeEntity.getSalary(),
                    departmentName);
        }
    }

    public EmployeeWithDepartmentIdDTO entityToEmployeeWithDepartmentIdDTO(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) {
            return null;
        } else {
            return new EmployeeWithDepartmentIdDTO(employeeEntity.getId(),
                    employeeEntity.getName(),
                    employeeEntity.getPosition(),
                    employeeEntity.getDepartmentId(),
                    employeeEntity.getSalary());
        }
    }
}
