create table department_audit(
    id bigserial primary key,
    performer varchar(255) not null,
    department_id bigint not null,
    operation_type varchar(255) not null,
    operation_date timestamp
);
