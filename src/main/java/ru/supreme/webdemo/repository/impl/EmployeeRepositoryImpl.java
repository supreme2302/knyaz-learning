package ru.supreme.webdemo.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    private final EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return jdbcTemplate.query("select id as employee_id, name, position, salary, department_id from employee", employeeRowMapper);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        jdbcTemplate.update("insert into employee(department_id, name, position, salary) values (?, ?, ?, ?)",
                employeeEntity.getDepartmentId(), employeeEntity.getName(), employeeEntity.getPosition(), employeeEntity.getSalary());
        return employeeEntity;
    }

    @Override
    public void deleteEmployee(Long id) {
        jdbcTemplate.update("delete from employee where id = ?", id);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select id as employee_id, name, position, salary, department_id from employee where id = ?",
                    employeeRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity) {
        jdbcTemplate.update("update employee set name = ?, position = ?, department_id = ?, salary = ? where id = ?;",
                employeeEntity.getName(),
                employeeEntity.getPosition(),
                employeeEntity.getDepartmentId(),
                employeeEntity.getSalary(),
                id);
        return employeeEntity;
    }

    //todo Чтобы маппить несколько строк на один объект нужен ResultSetExtractor

    private static class EmployeeRowMapper implements RowMapper<EmployeeEntity> {

        @Override
        public EmployeeEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(resultSet.getLong("employee_id"));
            employeeEntity.setName(resultSet.getString("name"));
            employeeEntity.setPosition(resultSet.getString("position"));
            employeeEntity.setDepartmentId(resultSet.getLong("department_id"));
            employeeEntity.setSalary(resultSet.getBigDecimal("salary"));
            return employeeEntity;
        }
    }
}
