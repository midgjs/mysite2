drop table users;
drop sequence seq_users_no;

create table users (
    no number,
    id varchar2(20) unique not null,
    password varchar2(20) not null,
    name varchar2(20),
    gender varchar2(10),
    primary key(no)
);

create sequence seq_users_no
increment by 1
start with 1
nocache;

insert into users
values(seq_users_no.nextval,'hijava','1234','¿Ã¿Á»∆','male');

select * from users;
