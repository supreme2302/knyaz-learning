package ru.supreme.webdemo.model.dto;

import java.math.BigDecimal;

public class EmployeeDTO {

    /**
     * Идентификатор работника
     */
    private Long id;

    /**
     * Имя работника
     */
    private String name;

    /**
     * Должность работника
     */
    private String position;

    private String departmentName;

    private BigDecimal salary;

    public EmployeeDTO(Long id, String name, String position, BigDecimal salary, String departmentName) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
