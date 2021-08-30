package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.errorMessages.ErrorMessageDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.service.DepartmentService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static ru.supreme.webdemo.WebDemoConst.USER_SESSION_ATTRIBUTE;

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
    public ResponseEntity<?> findDepartmentById(@PathVariable(value = "id") Long id) {
        DepartmentWithEmployeeListDTO departmentWithEmployeeListDTO = departmentService.findDepartmentById(id);
        if (departmentWithEmployeeListDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                    "Please be more attentive and try again"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(departmentWithEmployeeListDTO);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DepartmentWithEmployeeListDTO departmentDTO, HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.create(departmentDTO, userDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        }
        if (departmentService.findDepartmentById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                    "Please be more attentive and try again"));
        } else {
            departmentService.delete(id, userDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Department was deleted!");
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id,
                                    @RequestBody DepartmentWithoutEmployeeListDTO departmentDTO, HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        }
        DepartmentWithoutEmployeeListDTO departmentWithoutEmployeeListDTO = departmentService.update(id, departmentDTO, userDTO);
        if (departmentWithoutEmployeeListDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                    "Please be more attentive and try again"));
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentWithoutEmployeeListDTO);
        }
    }
}
