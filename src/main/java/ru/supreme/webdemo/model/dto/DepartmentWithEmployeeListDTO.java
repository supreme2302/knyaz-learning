package ru.supreme.webdemo.model.dto;

import ru.supreme.webdemo.model.entity.EmployeeEntity;

import java.util.List;

public class DepartmentWithEmployeeListDTO {

    private Long id;

    private String direction;

    private Float salaryCoefficient;

    private List<EmployeeEntity> employees;

    public DepartmentWithEmployeeListDTO(Long id,
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

    public float getSalaryCoefficient() {
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
