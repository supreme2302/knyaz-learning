package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity departmentEntity){
        departmentService.saveDepartment(departmentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentEntity);
    }
}
