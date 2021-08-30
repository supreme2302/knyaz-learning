package ru.supreme.webdemo.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UserDTO {

    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
    private String username;

    @Min(value = 4, message = "Password must be more than 3 characters")
    private String password;

    private Long id;

    public UserDTO(String username, String password, Long id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
