create table employees
(
    employeeid   serial not null
        constraint employees_pkey
            primary key,
    name         varchar(30),
    position     varchar(30),
    salary       numeric,
    departmentid integer
);

create table departments
(
    departmentid      serial not null
        constraint departments_pkey
            primary key,
    head              varchar(30),
    direction         varchar(30),
    salarycoefficient numeric
);