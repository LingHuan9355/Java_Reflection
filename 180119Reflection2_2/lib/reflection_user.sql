create table student(
  id int(11) auto_increment primary key,
  name varchar(30) not null,
  momey double(16,2) not null,
  brithday date not null
)


select * from student

insert into student(name,momey,brithday) values('admin',10.12,'1997-07-01');
commit;
insert into student(name,momey,brithday) values('lisi',14.12,'1997-05-05');
commit;
insert into student(name,momey,brithday) values('tom',15.2,'1993-05-01');
commit;
insert into student(name,momey,brithday) values('cat',29.12,'1996-02-05');
commit;
insert into student(name,momey,brithday) values('jack',18.12,'1995-03-13');
commit;

delete  from student where id = 7
