create table author(
    id bigint primary key,
    name varchar(24) not null
);

create table book(
    id bigint primary key,
    title varchar(24) not null,
    author_id bigint references author(id),
    date timestamp not null
);

insert into author (id, name)
values (1, 'jora');
insert into book (id, title, author_id, date)
values (1, 'first jora book', 1, now()),
       (2, 'second jora book', 1, now()),
       (3, 'third jora book', 1, now()),
       (4, 'fourth jora book', 1, now());

insert into author (id, name)
values (2, 'гена');
insert into book (id, title, author_id, date)
values (5, 'первая книга гены', 2, now()),
       (6, 'вторая книга гены', 2, now()),
       (7, 'третья книга гены', 2, now()),
       (8, 'четвертая книга гены', 2, now())