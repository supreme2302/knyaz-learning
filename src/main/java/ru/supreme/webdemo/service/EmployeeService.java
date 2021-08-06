package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentIdDTO;
import ru.supreme.webdemo.model.dto.EmployeeWithDepartmentNameDTO;
import java.util.List;

public interface EmployeeService {

    List<EmployeeWithDepartmentNameDTO> findAllEmployees();

    EmployeeWithDepartmentIdDTO create(EmployeeWithDepartmentIdDTO employeeDTO);

    void delete(Long id);

    EmployeeWithDepartmentNameDTO findEmployeeById(Long id);

    List<EmployeeWithDepartmentNameDTO> findEmployeesByDepartmentId(Long id);

    EmployeeWithDepartmentIdDTO update(Long id, EmployeeWithDepartmentIdDTO employeeDTO);
}