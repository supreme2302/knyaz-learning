package ru.supreme.webdemo.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.EmployeeAuditEntity;
import ru.supreme.webdemo.repository.EmployeeAuditRepository;
import ru.supreme.webdemo.repository.rowmapper.EmployeeAuditRowMapper;

import java.util.List;

@Repository
public class EmployeeAuditRepositoryImpl implements EmployeeAuditRepository {

    private final JdbcTemplate jdbcTemplate;

    private final EmployeeAuditRowMapper employeeAuditRowMapper;

    public EmployeeAuditRepositoryImpl(JdbcTemplate jdbcTemplate, EmployeeAuditRowMapper employeeAuditRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeAuditRowMapper = employeeAuditRowMapper;
    }

    @Override
    public List<EmployeeAuditEntity> findAllRecords() {
        return jdbcTemplate.query("select id as operation_id, performer, employee_id, operation_type, operation_date" +
                " from employee_audit order by id asc", employeeAuditRowMapper);
    }

    @Override
    public EmployeeAuditEntity save(EmployeeAuditEntity employeeAuditEntity) {
        jdbcTemplate.update("insert into employee_audit(performer, employee_id, operation_type, operation_date) values (?, ?, ?, ?)",
                employeeAuditEntity.getPerformer(),
                employeeAuditEntity.getEmployeeId(),
                employeeAuditEntity.getOperationType(),
                employeeAuditEntity.getOperationDate());
        return employeeAuditEntity;
    }
}
