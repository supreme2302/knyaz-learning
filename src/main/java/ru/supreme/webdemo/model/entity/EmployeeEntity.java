package ru.supreme.webdemo.model.entity;

import java.math.BigDecimal;

/**
 * Класс работник
 */
public class EmployeeEntity {

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

    private Long departmentId;

    private BigDecimal salary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name, String position, Long departmentId, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
