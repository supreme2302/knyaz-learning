package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.DepartmentDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;

@Component
public class DepartmentMapper {

    public DepartmentDTO entityToDTO(DepartmentEntity departmentEntity){
        return new DepartmentDTO(departmentEntity.getId(),
                departmentEntity.getDirection(),
                departmentEntity.getSalaryCoefficient());
    }
}
