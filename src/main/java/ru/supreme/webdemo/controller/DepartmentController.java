package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<DepartmentEntity>> findAllDepartments(){
       return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAllDepartments());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity departmentEntity){
        departmentService.saveDepartment(departmentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentEntity);
    }
}
