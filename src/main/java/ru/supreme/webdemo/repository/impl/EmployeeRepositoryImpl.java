package ru.supreme.webdemo.repository.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    private final EntityMapper entityMapper = new EntityMapper();

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return jdbcTemplate.query("select id as employee_id, name, position, salary, department_id from employee", entityMapper);
    }

    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {
        jdbcTemplate.update("insert into employee(department_id, name, position, salary) values (?, ?, ?, ?)",
                employeeEntity.getDepartmentId(), employeeEntity.getName(), employeeEntity.getPosition(), employeeEntity.getSalary());
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select id as employee_id, name, position, salary, department_id from employee where id = ?",
                    entityMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    //todo Чтобы маппить несколько строк на один объект нужен ResultSetExtractor

    private static class EntityMapper implements RowMapper<EmployeeEntity> {

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
