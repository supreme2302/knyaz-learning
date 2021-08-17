package ru.supreme.webdemo.service;

import ru.supreme.webdemo.model.dto.DepartmentAuditDTO;

import java.util.List;

public interface DepartmentAuditService {

    List<DepartmentAuditDTO> findAllRecords();
}
