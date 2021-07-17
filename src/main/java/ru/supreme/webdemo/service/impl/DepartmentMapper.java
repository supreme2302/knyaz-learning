package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.DepartmentDTO;

@Component
public class DepartmentMapper {

    public DepartmentDTO entityToDTO(DepartmentDTO departmentEntity){
        return new DepartmentDTO(departmentEntity.getId(),
                departmentEntity.getDirection(),
                departmentEntity.getSalaryCoefficient());
    }
}
