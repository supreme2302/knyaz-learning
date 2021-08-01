package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<DepartmentWithoutEmployeeListDTO> findAllDepartments() {
        List<DepartmentWithoutEmployeeListDTO> departmentDTOList = new ArrayList<>();
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAllDepartments();
        for (DepartmentEntity departmentEntity : departmentEntityList) {
            departmentDTOList.add(departmentMapper.entityToDepartmentWithoutEmployeeDTO(departmentEntity));
        }
        return departmentDTOList;
    }

    @Override
    public List<DepartmentWithEmployeeListDTO> findAllDepartmentsWithEmployees() {
        List<DepartmentWithEmployeeListDTO> departmentWithEmployeeListDTO = new ArrayList<>();
        List<DepartmentEntity> departments = departmentRepository.findAllDepartmentsWithEmployees();
        for (DepartmentEntity departmentEntity : departments) {
            departmentWithEmployeeListDTO.add(departmentMapper.entityToDepartmentWithEmployeeListDTO(departmentEntity));
        }
        return departmentWithEmployeeListDTO;
    }

    @Override
    public DepartmentWithEmployeeListDTO findDepartmentById(Long id) {
        return departmentMapper.entityToDepartmentWithEmployeeListDTO(departmentRepository.findDepartmentById(id));
    }

    @Override
    public DepartmentWithoutEmployeeListDTO create(DepartmentEntity departmentEntity) {
        return departmentMapper.entityToDepartmentWithoutEmployeeDTO(departmentRepository.save(departmentEntity));
    }

    @Override
    public void delete(Long id) {
        departmentRepository.delete(id);
    }

    @Override
    public DepartmentWithoutEmployeeListDTO update(Long id, DepartmentEntity departmentEntity) {
        DepartmentEntity newDepartmentEntity = departmentRepository.findDepartmentById(id);
        if (newDepartmentEntity == null) {
            return null;
        } else {
            if (departmentEntity.getDirection() != null) {
                newDepartmentEntity.setDirection(departmentEntity.getDirection());
            }
            if (departmentEntity.getSalaryCoefficient() != null) {
                newDepartmentEntity.setSalaryCoefficient(departmentEntity.getSalaryCoefficient());
            }
            return departmentMapper.entityToDepartmentWithoutEmployeeDTO(departmentRepository.update(id, newDepartmentEntity));
        }
    }
}
