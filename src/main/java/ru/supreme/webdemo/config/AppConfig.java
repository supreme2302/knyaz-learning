package ru.supreme.webdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.supreme.webdemo.service.impl.DepartmentMapper;
import ru.supreme.webdemo.service.impl.EmployeeMapper;
import ru.supreme.webdemo.service.impl.UserMapper;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public EmployeeMapper employeeMapper() {
        return new EmployeeMapper();
    }

    @Bean
    public DepartmentMapper departmentMapper() {
        return new DepartmentMapper();
    }
}
