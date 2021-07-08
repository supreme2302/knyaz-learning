package ru.supreme.webdemo.model.entity;

import java.util.List;

public class DepartmentEntity {

    private Long id;

    private String direction;

    private Float salaryCoefficient;

    private List<EmployeeEntity> employees;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Long id,
                            String direction,
                            Float salaryCoefficient,
                            List<EmployeeEntity> employees) {
        this.id = id;
        this.direction = direction;
        this.salaryCoefficient = salaryCoefficient;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Float getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(Float salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
