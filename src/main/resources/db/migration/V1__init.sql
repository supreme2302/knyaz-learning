create table department(
    id bigserial primary key,
    head varchar(30) not null,
    direction varchar(30) not null,
    salary_coefficient numeric not null
);

create table employee(
    id bigserial primary key,
    department_id bigint references department(id),
    name varchar(30) not null,
    position varchar(30) not null,
    salary numeric not null
);