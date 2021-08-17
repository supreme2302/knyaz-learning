package ru.supreme.webdemo.model.dto;

import java.time.LocalDateTime;

public class DepartmentAuditDTO {

    private Long id;

    private String performer;

    private Long departmentId;

    private String operationType;

    private LocalDateTime operationDate;

    public DepartmentAuditDTO(Long id,
                              String performer,
                              Long employeeId,
                              String operationType,
                              LocalDateTime operationDate) {
        this.id = id;
        this.performer = performer;
        this.departmentId = employeeId;
        this.operationType = operationType;
        this.operationDate = operationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }
}
