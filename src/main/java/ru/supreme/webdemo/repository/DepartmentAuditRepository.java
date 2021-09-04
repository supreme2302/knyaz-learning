package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.DepartmentAuditEntity;

import java.util.List;

public interface DepartmentAuditRepository {

    List<DepartmentAuditEntity> findAllRecords();

    DepartmentAuditEntity save(DepartmentAuditEntity departmentAuditEntity);
}
