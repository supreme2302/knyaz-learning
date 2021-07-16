package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentRepository {



    List<DepartmentEntity> findAllDepartments();

    DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    void deleteDepartment(Long id);

    DepartmentEntity updateDepartment(Long id);

    DepartmentEntity findDepartmentInfoByDepartmentId(Long id);

//    todo Понять, как посчитать затраты на зарплату по отделам, потом в Эмплоии добавить метод для
//    подсчета зарплаты работника

      List<DepartmentEntity> countDepartmentsSalaryExpenses();
}
