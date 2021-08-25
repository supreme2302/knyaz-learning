package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.errorMessages.ErrorMessageDTO;
import ru.supreme.webdemo.errorMessages.RomkaCustomException;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.service.EmployeeService;

import javax.servlet.http.HttpSession;
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

    @GetMapping
    public ResponseEntity<?> findAllEmployees(@RequestParam(name = "departmentId", required = false) Long id,
                                              @RequestParam(name = "page", required = false) Integer page) throws RomkaCustomException {
        if (id != null) {
            List<EmployeeWithDepartmentNameDTO> list = employeeService.findEmployeesByDepartmentId(id);
            if (list == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                        "Please be more attentive and try again"));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(list);
            }
        }
        if (page != null) {
            List<EmployeeWithDepartmentNameDTO> paging = employeeService.findPage(page);
            return ResponseEntity.status(HttpStatus.OK).body(paging);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAllEmployees());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findEmployeeById(@PathVariable(value = "id") Long id) {
        EmployeeWithDepartmentNameDTO employeeWithDepartmentNameDTO = employeeService.findEmployeeById(id);
        if (employeeWithDepartmentNameDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                    "Please be more attentive and try again"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeWithDepartmentNameDTO);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeWithDepartmentIdDTO employee,
                                    HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee, userDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        }
        if (employeeService.findEmployeeById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                    "Please be more attentive and try again"));
        } else {
            employeeService.delete(id, userDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Employee was deleted!");
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id,
                                    @RequestBody EmployeeWithDepartmentIdDTO employeeDTO, HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        }
        EmployeeWithDepartmentIdDTO employeeWithDepartmentIdDTO = employeeService.update(id, employeeDTO, userDTO);
        if (employeeWithDepartmentIdDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO("Wrong request. " +
                    "Please be more attentive and try again"));
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeWithDepartmentIdDTO);
        }
    }
}
