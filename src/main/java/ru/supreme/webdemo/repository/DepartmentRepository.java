package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.DepartmentDTO;

import java.util.List;

public interface DepartmentRepository {



    List<DepartmentDTO> findAllDepartments();

    DepartmentDTO findDepartmentById(Long id);

    DepartmentDTO saveDepartment(DepartmentDTO departmentEntity);

    void deleteDepartment(Long id);

    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentEntity);

    DepartmentDTO findDepartmentInfoByDepartmentId(Long id);

//    todo Понять, как посчитать затраты на зарплату по отделам, потом в Эмплоии добавить метод для
//    подсчета зарплаты работника

}
