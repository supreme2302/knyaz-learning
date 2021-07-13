package ru.supreme.webdemo.model.dto;

import java.math.BigDecimal;

public class DepartmentDTO {

    private Long id;

    private String direction;

    private BigDecimal salaryCoefficient;

    public DepartmentDTO(Long id, String direction, BigDecimal salaryCoefficient)
    {
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
