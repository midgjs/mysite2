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
values(seq_users_no.nextval,'hijava','1234','이재훈','male');

select * from users;

drop table board;

drop sequence seq_board_no;

create table board (
    no number,
    title varchar2(500) not null,
    content varchar2(4000),
    hit number,
    reg_date date not null,
    user_no number not null,
    primary key(no),
    constraint board_fk foreign key (user_no)
    REFERENCES users(no)
);

create sequence seq_board_no
increment by 1
start with 1
nocache;

insert into board
values(seq_board_no.nextval,'제목','내용',0,'2001/01/01',1);

select * from board;