package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.dto.EmployeeDTO;
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

    @GetMapping(value = "/list")
    public ResponseEntity<List<EmployeeEntity>> findAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAllEmployees());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.saveEmployee(employeeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<EmployeeDTO> findEmployeeById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeeById(id));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Long id,
                                                         @RequestBody EmployeeEntity employeeEntity) {
        employeeService.updateEmployee(id, employeeEntity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.updateEmployee(id, employeeEntity));
    }
}

