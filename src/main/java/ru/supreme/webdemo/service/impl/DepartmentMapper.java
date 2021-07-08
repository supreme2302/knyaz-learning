package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;

@Component
public class DepartmentMapper {

    public DepartmentWithoutEmployeeListDTO entityToDepartmentWithoutEmployeeDTO(DepartmentEntity departmentEntity) {
        if (departmentEntity == null) {
            return null;
        } else {
            return new DepartmentWithoutEmployeeListDTO(departmentEntity.getId(),
                    departmentEntity.getDirection(),
                    departmentEntity.getSalaryCoefficient());
        }
    }

    public DepartmentWithEmployeeListDTO entityToDepartmentWithEmployeeListDTO(DepartmentEntity departmentEntity) {
        if (departmentEntity == null) {
            return null;
        } else {
            return new DepartmentWithEmployeeListDTO(departmentEntity.getId(),
                    departmentEntity.getDirection(),
                    departmentEntity.getSalaryCoefficient(),
                    departmentEntity.getEmployees());
        }
    }
}
