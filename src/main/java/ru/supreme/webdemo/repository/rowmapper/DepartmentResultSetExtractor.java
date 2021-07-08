package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentResultSetExtractor implements ResultSetExtractor<DepartmentEntity> {

    private final DepartmentRowMapper departmentRowMapper;

    private final EmployeeRowMapper employeeRowMapper;

    public DepartmentResultSetExtractor(DepartmentRowMapper departmentRowMapper,
                                        EmployeeRowMapper employeeRowMapper) {
        this.departmentRowMapper = departmentRowMapper;
        this.employeeRowMapper = employeeRowMapper;
    }

    @Override
    public DepartmentEntity extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        DepartmentEntity departmentEntity = null;
        while (resultSet.next()) {
            if (departmentEntity == null) {
                departmentEntity = departmentRowMapper.mapRow(resultSet);
            }
            EmployeeEntity employeeEntity = employeeRowMapper.mapRow(resultSet);
            if (employeeEntity != null) {
                employeeEntityList.add(employeeEntity);
            }
            departmentEntity.setEmployees(employeeEntityList);
        }
        return departmentEntity;
    }
}
