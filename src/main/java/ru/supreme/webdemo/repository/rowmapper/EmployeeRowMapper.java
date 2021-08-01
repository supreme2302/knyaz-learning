package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<EmployeeEntity> {

    @Override
    public EmployeeEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    public EmployeeEntity mapRow(ResultSet resultSet) throws SQLException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(resultSet.getLong("employee_id"));
        if (resultSet.getLong("employee_id") == 0l) {
            return null;
        }
        employeeEntity.setName(resultSet.getString("name"));
        employeeEntity.setPosition(resultSet.getString("position"));
        employeeEntity.setDepartmentId(resultSet.getLong("department_id"));
        employeeEntity.setSalary(resultSet.getBigDecimal("salary"));
        return employeeEntity;
    }
}
