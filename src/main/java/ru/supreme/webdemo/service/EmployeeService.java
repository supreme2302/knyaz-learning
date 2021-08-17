package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import ru.supreme.webdemo.model.dto.UserDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeWithDepartmentNameDTO> findAllEmployees();

    EmployeeWithDepartmentIdDTO create(EmployeeWithDepartmentIdDTO employeeDTO, UserDTO userDTO);

    void delete(Long id, UserDTO userDTO);

    EmployeeWithDepartmentNameDTO findEmployeeById(Long id);

    List<EmployeeWithDepartmentNameDTO> findEmployeesByDepartmentId(Long id);

    EmployeeWithDepartmentIdDTO update(Long id, EmployeeWithDepartmentIdDTO employeeDTO, UserDTO userDTO);
}