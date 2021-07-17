package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.entity.DepartmentDTO;
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
    public ResponseEntity<List<DepartmentDTO>> findAllDepartments(){
       return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAllDepartments());
    }

    @GetMapping
    public ResponseEntity<DepartmentDTO> findDepartmentById(@RequestParam (value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findDepartmentById(id));
    }


    @PostMapping(value = "/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentEntity){
        departmentService.saveDepartment(departmentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable(value = "id") Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable(value = "id") Long id,
                                                          @RequestBody DepartmentDTO departmentEntity){
        departmentService.updateDepartment(id, departmentEntity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentEntity);
    }
}
