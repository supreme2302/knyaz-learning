package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.EmployeeDTO;
import ru.supreme.webdemo.model.entity.EmployeeEntity;

@Component
public class EmployeeMapper {

    public EmployeeDTO entityToDTO(EmployeeEntity employeeEntity, String departmentName) {
        return new EmployeeDTO(employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getPosition(),
                employeeEntity.getSalary(),
                departmentName);
    }
}
