create database ss1_baitap;

use ss1_baitap;

create table class(
id_name int primary key auto_increment,
name_class varchar(255)
);

insert into class(name_class)
value ('Nguyen Van A'),
('Nguyen Van B'),
('Nguyen Van C');

select * from class;

update class
set name_class ='C0922G1'
where id_name =1;

update class
set name_class ='C1022G1'
where id_name =2;

update class
set name_class ='C1122G1'
where id_name =3;

create table teacher(
id_teacher int primary key auto_increment,
name_teacher varchar(255),
age_teacher int,
country varchar(255) 
);

insert into teacher(name_teacher,age_teacher,country)
value ('Nguyen Van A',20,'Da Nang'),
('Nguyen Van B',21,'Ha Noi'),
('Nguyen Van C',22,'Hue');

select * from teacher;

update teacher
set age_teacher=30
where id_teacher=2;

drop table teacher;
