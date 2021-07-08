package ru.supreme.webdemo.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.repository.DepartmentRepository;
import ru.supreme.webdemo.repository.rowmapper.DepartmentListResultSetExtractor;
import ru.supreme.webdemo.repository.rowmapper.DepartmentResultSetExtractor;
import ru.supreme.webdemo.repository.rowmapper.DepartmentRowMapper;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    private final DepartmentRowMapper departmentRowMapper;

    private final DepartmentResultSetExtractor departmentResultSetExtractor;

    private final DepartmentListResultSetExtractor departmentListResultSetExtractor;

    public DepartmentRepositoryImpl(JdbcTemplate jdbcTemplate,
                                    DepartmentRowMapper departmentRowMapper,
                                    DepartmentResultSetExtractor departmentResultSetExtractor,
                                    DepartmentListResultSetExtractor departmentListResultSetExtractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.departmentRowMapper = departmentRowMapper;
        this.departmentResultSetExtractor = departmentResultSetExtractor;
        this.departmentListResultSetExtractor = departmentListResultSetExtractor;
    }

    @Override
    public List<DepartmentEntity> findAllDepartments() {
        return jdbcTemplate.query("select id as department_id, direction, salary_coefficient from department",
                departmentRowMapper);
    }

    @Override
    public List<DepartmentEntity> findAllDepartmentsWithEmployees() {
        return jdbcTemplate.query("select d.id as department_id, d.direction, d.salary_coefficient, e.id as " +
                        "employee_id, e.name, e.position, e.salary, e.department_id from department d " +
                        "left join employee e on d.id = e.department_id order by e.id asc",
                departmentListResultSetExtractor);
    }

    @Override
    public DepartmentEntity findDepartmentById(Long id) {
        return jdbcTemplate.query("select d.id as department_id, d.direction, d.salary_coefficient, " +
                        "e.id as employee_id, e.name, e.position, e.salary, e.department_id from department d " +
                        "left join employee e on d.id = e.department_id " +
                        "where d.id = ? order by e.id asc",
                departmentResultSetExtractor,
                id);
    }

    @Override
    public DepartmentEntity save(DepartmentEntity departmentEntity) {
        jdbcTemplate.update("insert into department (direction, salary_coefficient) values (?, ?)",
                departmentEntity.getDirection(),
                departmentEntity.getSalaryCoefficient());
        return departmentEntity;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from department where id = ?", id);
    }

    @Override
    public DepartmentEntity update(Long id, DepartmentEntity departmentEntity) {
        jdbcTemplate.update("update department set direction = ?, salary_coefficient = ? where id = ?",
                departmentEntity.getDirection(),
                departmentEntity.getSalaryCoefficient(),
                id);
        return departmentEntity;
    }
}
