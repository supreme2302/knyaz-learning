package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final List<DepartmentEntity> departmentEntities = new ArrayList<>();

    public DepartmentRepositoryImpl() {
        List<EmployeeEntity> employeeEntityList1 = new ArrayList<>();
//        employeeEntityList1.add(new EmployeeEntity(1L, "Knyaz", "Developer", 1L));
//        employeeEntityList1.add(new EmployeeEntity(2L, "Koshka", "Dealer", 1L));
        List<EmployeeEntity> employeeEntityList2 = new ArrayList<>();
//        employeeEntityList2.add(new EmployeeEntity(3L, "Eye of Sauron", "Engineer", 2L));
        departmentEntities.add(new DepartmentEntity(1L, "Market", employeeEntityList1));
        departmentEntities.add(new DepartmentEntity(2L, "IT", employeeEntityList2));
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return departmentEntities;
    }

    @Override
    public DepartmentEntity findById(Long id) {
        for (DepartmentEntity departmentEntity : departmentEntities) {
            if (departmentEntity.getId().equals(id)) {
                return departmentEntity;
            }
        }
        return null;
    }
}
