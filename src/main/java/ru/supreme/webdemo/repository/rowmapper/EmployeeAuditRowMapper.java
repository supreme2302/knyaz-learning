package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.EmployeeAuditEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeAuditRowMapper implements RowMapper<EmployeeAuditEntity> {

    @Override
    public EmployeeAuditEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    public EmployeeAuditEntity mapRow(ResultSet resultSet) throws SQLException {

        EmployeeAuditEntity employeeAudit = new EmployeeAuditEntity();
        employeeAudit.setId(resultSet.getLong("operation_id"));
        employeeAudit.setPerformer(resultSet.getString("performer"));
        employeeAudit.setEmployeeId(resultSet.getLong("employee_id"));
        employeeAudit.setOperationType(resultSet.getString("operation_type"));
        employeeAudit.setOperationDate(resultSet.getTimestamp("operation_date").toLocalDateTime());
        return employeeAudit;
    }
}
