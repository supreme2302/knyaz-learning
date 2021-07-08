package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Обрати внивание, что мы внедряем зависимость через интерфейс EmployeeService,
     * а не через его реализацию EmployeeServiceImpl
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeWithDepartmentNameDTO>> findAllEmployees(@RequestParam(name = "departmentId", required = false) Long id) {
        if (id != null) {
            List<EmployeeWithDepartmentNameDTO> list = employeeService.findEmployeesByDepartmentId(id);
            if (list == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(list);
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAllEmployees());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeWithDepartmentNameDTO> findEmployeeById(@PathVariable(value = "id") Long id) {
        EmployeeWithDepartmentNameDTO employeeWithDepartmentNameDTO = employeeService.findEmployeeById(id);
        if (employeeWithDepartmentNameDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeWithDepartmentNameDTO);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeWithDepartmentIdDTO> create(@RequestBody EmployeeEntity employeeEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employeeEntity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        if (employeeService.findEmployeeById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            employeeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<EmployeeWithDepartmentIdDTO> update(@PathVariable(value = "id") Long id,
                                                              @RequestBody EmployeeEntity employeeEntity) {
        EmployeeWithDepartmentIdDTO employeeWithDepartmentIdDTO = employeeService.update(id, employeeEntity);
        if (employeeWithDepartmentIdDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeWithDepartmentIdDTO);
        }
    }
}
