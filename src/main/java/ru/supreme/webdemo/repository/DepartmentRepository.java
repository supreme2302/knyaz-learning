package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentRepository {


    List<DepartmentEntity> findAllDepartments();

    List<DepartmentEntity> findAllDepartmentsWithEmployees();

    DepartmentEntity findDepartmentById(Long id);

    DepartmentEntity save(DepartmentEntity departmentEntity);

    void delete(Long id);

    DepartmentEntity update(Long id, DepartmentEntity departmentEntity);

//    todo Понять, как посчитать затраты на зарплату по отделам, потом в Эмплоии добавить метод для
//    подсчета зарплаты работника

}
