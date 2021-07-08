package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.DepartmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentRowMapper implements RowMapper<DepartmentEntity> {
    @Override
    public DepartmentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    public DepartmentEntity mapRow(ResultSet resultSet) throws SQLException {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(resultSet.getLong("department_id"));
        departmentEntity.setDirection(resultSet.getString("direction"));
        departmentEntity.setSalaryCoefficient(resultSet.getFloat("salary_coefficient"));
        return departmentEntity;
    }
}
