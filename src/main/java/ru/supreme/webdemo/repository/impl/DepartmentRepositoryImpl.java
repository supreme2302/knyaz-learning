package ru.supreme.webdemo.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.DepartmentDTO;
import ru.supreme.webdemo.repository.DepartmentRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    private final DepartmentRowMapper departmentRowMapper = new DepartmentRowMapper();

    public DepartmentRepositoryImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DepartmentDTO> findAllDepartments() {
       return jdbcTemplate.query("select id as department_id, direction, salary_coefficient from department",
                departmentRowMapper);
    }

    @Override
    public DepartmentDTO findDepartmentById(Long id) {
       try {
           return jdbcTemplate.queryForObject("select id as department_id, direction, salary_coefficient from department where id = ?",
                   departmentRowMapper,
                   id);
       } catch (EmptyResultDataAccessException e) {
           return null;
       }
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentEntity) {
        jdbcTemplate.update("insert into department (direction, salary_coefficient) values (?, ?)",
                departmentEntity.getDirection(),
                departmentEntity.getSalaryCoefficient());
        return departmentEntity;
    }

    @Override
    public void deleteDepartment(Long id) {
        jdbcTemplate.update("delete from department where id = ?", id);
    }
    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentEntity) {
        jdbcTemplate.update("update department set direction = ?, salary_coefficient = ? where id = ?",
                departmentEntity.getDirection(),
                departmentEntity.getSalaryCoefficient(),
                id);
        return departmentEntity;
    }

    @Override
    public DepartmentDTO findDepartmentInfoByDepartmentId(Long id) {
        return null;
    }

    public DepartmentDTO findEmployeesByDepartmentId(Long id) {
        return null;
    }

    private static class DepartmentRowMapper implements RowMapper<DepartmentDTO>{
        public DepartmentDTO mapRow(ResultSet resultSet, int i) throws SQLException {
            DepartmentDTO departmentEntity = new DepartmentDTO();
            departmentEntity.setId(resultSet.getLong("department_id"));
            departmentEntity.setDirection(resultSet.getString("direction"));
            departmentEntity.setSalaryCoefficient(resultSet.getBigDecimal("salary_coefficient"));
            return departmentEntity;
        }
    }

}
