package ru.supreme.webdemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.service.EmployeeAuditService;

import javax.servlet.http.HttpSession;

import static ru.supreme.webdemo.WebDemoConst.USER_SESSION_ATTRIBUTE;

@RestController
@RequestMapping(value = "/employee-audit")
public class EmployeeAuditController {

    private final EmployeeAuditService employeeAuditService;

    public EmployeeAuditController(EmployeeAuditService employeeAuditService) {
        this.employeeAuditService = employeeAuditService;
    }

    @GetMapping
    public ResponseEntity<?> findAllRecords(HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be authenticated!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeAuditService.findAllRecords());
        }
    }
}