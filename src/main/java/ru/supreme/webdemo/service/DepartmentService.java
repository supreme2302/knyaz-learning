package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.DepartmentWithEmployeeListDTO;
import ru.supreme.webdemo.model.dto.DepartmentWithoutEmployeeListDTO;
import ru.supreme.webdemo.model.dto.UserDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentWithoutEmployeeListDTO> findAllDepartments();

    List<DepartmentWithEmployeeListDTO> findAllDepartmentsWithEmployees();

    DepartmentWithEmployeeListDTO findDepartmentById(Long id);

    DepartmentWithEmployeeListDTO create(DepartmentWithEmployeeListDTO departmentDTO, UserDTO userDTO);

    void delete(Long id, UserDTO userDTO);

    DepartmentWithoutEmployeeListDTO update(Long id,
                                            DepartmentWithoutEmployeeListDTO departmentDTO,
                                            UserDTO userDTO);
}
