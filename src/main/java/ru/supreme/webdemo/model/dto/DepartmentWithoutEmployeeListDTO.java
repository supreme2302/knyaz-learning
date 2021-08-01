package ru.supreme.webdemo.model.dto;

public class DepartmentWithoutEmployeeListDTO {

    private Long id;

    private String direction;

    private Float salaryCoefficient;

    public DepartmentWithoutEmployeeListDTO(Long id,
                                            String direction,
                                            Float salaryCoefficient) {
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

    public float getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(Float salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }
}
