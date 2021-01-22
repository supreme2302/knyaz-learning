package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.Employee;
import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.service.EmployeeService;

import javax.servlet.http.HttpSession;
import java.lang.invoke.VolatileCallSite;
import java.util.List;

import static ru.supreme.webdemo.WebDemoConst.USER_SESSION_ATTRIBUTE;

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
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (user == null) {
        }
        employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public ResponseEntity<Employee> getEmployeeById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }
}

