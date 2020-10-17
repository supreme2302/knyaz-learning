package ru.supreme.webdemo.model;

/**
 * Класс работник
 */
public class Employee {

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

    public Employee() {}

    public Employee(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
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
}
