package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.DepartmentAuditEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentAuditRowMapper implements RowMapper<DepartmentAuditEntity> {

    @Override
    public DepartmentAuditEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    public DepartmentAuditEntity mapRow(ResultSet resultSet) throws SQLException {
        DepartmentAuditEntity departmentAudit = new DepartmentAuditEntity();
        departmentAudit.setId(resultSet.getLong("operation_id"));
        departmentAudit.setPerformer(resultSet.getString("performer"));
        departmentAudit.setDepartmentId(resultSet.getLong("department_id"));
        departmentAudit.setOperationType(resultSet.getString("operation_type"));
        departmentAudit.setOperationDate(resultSet.getTimestamp("operation_date").toLocalDateTime());
        return departmentAudit;
    }
}
