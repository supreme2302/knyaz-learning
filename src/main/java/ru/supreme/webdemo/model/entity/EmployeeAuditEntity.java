package ru.supreme.webdemo.model.entity;

import java.time.LocalDateTime;

public class EmployeeAuditEntity {

    private Long id;

    private String performer;

    private Long employeeId;

    private String operationType;

    private LocalDateTime operationDate;

    public EmployeeAuditEntity() {
    }

    public EmployeeAuditEntity(Long id,
                               String performer,
                               Long employeeId,
                               String operationType,
                               LocalDateTime operationDate) {
        this.id = id;
        this.performer = performer;
        this.employeeId = employeeId;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
