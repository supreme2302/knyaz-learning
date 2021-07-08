package ru.supreme.webdemo.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;
import ru.supreme.webdemo.repository.rowmapper.EmployeeRowMapper;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    private final EmployeeRowMapper employeeRowMapper;

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate, EmployeeRowMapper employeeRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRowMapper = employeeRowMapper;
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return jdbcTemplate.query("select id as employee_id, name, position, salary, department_id " +
                        "from employee order by id asc",
                employeeRowMapper);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        jdbcTemplate.update("insert into employee(department_id, name, position, salary) values (?, ?, ?, ?)",
                employeeEntity.getDepartmentId(),
                employeeEntity.getName(),
                employeeEntity.getPosition(),
                employeeEntity.getSalary());
        return employeeEntity;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from employee where id = ?", id);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select id as employee_id, name, position, salary, department_id " +
                            "from employee where id = ? order by id asc",
                    employeeRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public EmployeeEntity update(Long id, EmployeeEntity employeeEntity) {
        jdbcTemplate.update("update employee set name = ?, position = ?, department_id = ?, salary = ? where id = ?;",
                employeeEntity.getName(),
                employeeEntity.getPosition(),
                employeeEntity.getDepartmentId(),
                employeeEntity.getSalary(),
                id);
        return employeeEntity;
    }
}
