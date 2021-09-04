package ru.supreme.webdemo.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.DepartmentAuditEntity;
import ru.supreme.webdemo.repository.DepartmentAuditRepository;
import ru.supreme.webdemo.repository.rowmapper.DepartmentAuditRowMapper;

import java.util.List;

@Repository
public class DepartmentAuditRepositoryImpl implements DepartmentAuditRepository {

    private final DepartmentAuditRowMapper departmentAuditRowMapper;

    private final JdbcTemplate jdbcTemplate;

    public DepartmentAuditRepositoryImpl(DepartmentAuditRowMapper departmentAuditRowMapper,
                                         JdbcTemplate jdbcTemplate) {
        this.departmentAuditRowMapper = departmentAuditRowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DepartmentAuditEntity> findAllRecords() {
        return jdbcTemplate.query("select id as operation_id, performer, department_id, operation_type, operation_date " +
                        "from department_audit",
                departmentAuditRowMapper);
    }

    @Override
    public DepartmentAuditEntity save(DepartmentAuditEntity departmentAuditEntity) {
        jdbcTemplate.update("insert into department_audit(performer, department_id, operation_type, operation_date) " +
                        "values (?, ?, ?, ?)",
                departmentAuditEntity.getPerformer(),
                departmentAuditEntity.getDepartmentId(),
                departmentAuditEntity.getOperationType(),
                departmentAuditEntity.getOperationDate());
        return departmentAuditEntity;
    }
}
