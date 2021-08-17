package ru.supreme.webdemo.repository;

import ru.supreme.webdemo.model.entity.EmployeeAuditEntity;

import java.util.List;

public interface EmployeeAuditRepository {

    List<EmployeeAuditEntity> findAllRecords();

    EmployeeAuditEntity save(EmployeeAuditEntity employeeAuditEntity);
}
