package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class DepartmentListResultSetExtractor implements ResultSetExtractor<List<DepartmentEntity>> {

    private DepartmentRowMapper departmentRowMapper;

    private EmployeeRowMapper employeeRowMapper;

    public DepartmentListResultSetExtractor(DepartmentRowMapper departmentRowMapper,
                                            EmployeeRowMapper employeeRowMapper) {
        this.departmentRowMapper = departmentRowMapper;
        this.employeeRowMapper = employeeRowMapper;
    }

    @Override
    public List<DepartmentEntity> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Long, DepartmentEntity> departments = new LinkedHashMap<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("department_id");
            if (!(departments.containsKey(id))) {
                DepartmentEntity departmentEntity;
                departmentEntity = departmentRowMapper.mapRow(resultSet);
                departmentEntity.setEmployees(new ArrayList<>());
                departments.put(id, departmentEntity);
            }
            EmployeeEntity employeeEntity = employeeRowMapper.mapRow(resultSet);
            if (employeeEntity != null) {
                DepartmentEntity departmentEntity = departments.get(id);
                departmentEntity.getEmployees().add(employeeEntity);
            }
        }
        return new ArrayList<>(departments.values());
    }
}
