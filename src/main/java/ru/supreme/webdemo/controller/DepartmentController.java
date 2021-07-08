package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.entity.DepartmentEntity;
import ru.supreme.webdemo.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentWithoutEmployeeListDTO>> findAllDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAllDepartments());
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<DepartmentWithEmployeeListDTO>> findAllDepartmentsWithEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAllDepartmentsWithEmployees());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentWithEmployeeListDTO> findDepartmentById(@PathVariable(value = "id") Long id) {
        DepartmentWithEmployeeListDTO departmentWithEmployeeListDTO = departmentService.findDepartmentById(id);
        if (departmentWithEmployeeListDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(departmentWithEmployeeListDTO);
        }
    }

    @PostMapping
    public ResponseEntity<DepartmentWithoutEmployeeListDTO> create(@RequestBody DepartmentEntity departmentEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.create(departmentEntity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {

        if (departmentService.findDepartmentById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            departmentService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<DepartmentWithoutEmployeeListDTO> update(@PathVariable(value = "id") Long id,
                                                                   @RequestBody DepartmentEntity departmentEntity) {
        DepartmentWithoutEmployeeListDTO departmentWithoutEmployeeListDTO = departmentService.update(id, departmentEntity);
        if (departmentWithoutEmployeeListDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentWithoutEmployeeListDTO);
        }
    }
}
