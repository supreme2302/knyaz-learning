package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.EmployeeAuditDTO;

import java.util.List;

public interface EmployeeAuditService {

    List<EmployeeAuditDTO> findAllRecords();
}
