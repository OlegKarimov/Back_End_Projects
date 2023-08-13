insert into account(email, state, role)
values ('test@mail.com', 'NOT_CONFIRMED', 'USER');
insert into account(email, state, role)
values ('test1@mail.com', 'CONFIRMED', 'ADMIN');

insert into task(description, title, start_Date, finish_Date, executor_Id)
values ('Task 1', 'Task 1','2022-02-02','2022-02-03',1);
insert into task(description, title, start_Date, finish_Date, executor_Id)
values ('Task 2', 'Task 2','2022-03-02','2022-03-03',1);