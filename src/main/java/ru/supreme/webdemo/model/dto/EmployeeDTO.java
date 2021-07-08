package ru.supreme.webdemo.model.dto;

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

    public EmployeeDTO(Long id, String name, String position, String departmentName) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.departmentName = departmentName;
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
}
