package ru.supreme.webdemo.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
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



//    @Override
//    public List<DepartmentEntity> findAllDepartmentsInfo() {
//        return departmentEntities;
//    }

    @Override
    public List<DepartmentEntity> findAllDepartments() {
        return null;
    }

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        jdbcTemplate.update("insert into department (direction, salary_coefficient) values (?, ?)",
                departmentEntity.getDirection(),
                departmentEntity.getGovno());
        return departmentEntity;
    }

    @Override
    public void deleteDepartment(Long id) {

    }

    @Override
    public DepartmentEntity updateDepartment(Long id) {
        return null;
    }

    @Override
    public DepartmentEntity findDepartmentInfoByDepartmentId(Long id) {
        return null;
    }

//    @Override
//    public DepartmentEntity findDepartmentInfoByDepartmentId(Long id) {
//        for (DepartmentEntity departmentEntity : departmentEntities) {
//            if (departmentEntity.getId().equals(id)) {
//                return departmentEntity;
//            }
//        }
//        return null;
//    }

    @Override
    public List<DepartmentEntity> countDepartmentsSalaryExpenses() {
        return null;
    }

    private static class DepartmentRowMapper implements RowMapper<DepartmentEntity>{
        public DepartmentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setId(resultSet.getLong("department_id"));
            departmentEntity.setDirection(resultSet.getString("direction"));
            departmentEntity.setGovno(resultSet.getBigDecimal("salary_coefficient"));
            return departmentEntity;
        }
    }

}
