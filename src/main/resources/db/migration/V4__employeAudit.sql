create table employee_audit(
    id bigserial primary key,
    performer varchar(255) not null,
    employee_id bigint not null,
    operation_type varchar(255) not null,
    operation_date timestamp
);