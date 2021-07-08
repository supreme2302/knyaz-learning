package ru.supreme.webdemo.model.entity;

import java.util.List;

public class DepartmentEntity {

    private Long id;

    private String name;

    private List<EmployeeEntity> employeeEntities;

    public DepartmentEntity(Long id, String name, List<EmployeeEntity> employeeEntities) {
        this.id = id;
        this.name = name;
        this.employeeEntities = employeeEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EmployeeEntity> getEmployees() {
        return employeeEntities;
    }

    public void setEmployees(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
