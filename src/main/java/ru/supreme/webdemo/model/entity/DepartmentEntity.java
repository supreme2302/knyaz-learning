package ru.supreme.webdemo.model.entity;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentEntity {

    private Long id;

    private String direction;

    private BigDecimal salaryCoefficient;

    public DepartmentEntity(){}

    public DepartmentEntity(Long id, String direction, BigDecimal salaryCoefficient) {
        this.id = id;
        this.direction = direction;
        this.salaryCoefficient = salaryCoefficient;
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

    public BigDecimal getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(BigDecimal salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }
}
