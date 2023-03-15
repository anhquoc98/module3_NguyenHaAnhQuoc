CREATE DATABASE demo1;
USE demo1;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users (name, email, country) values (?,?,?);

select id, name, email, country from users where id = ? order by name;

set sql_safe_updates = 0;
update users
set name = ?, email = ?, country = ? 
where id = ?;

delete from users where id = ?;

select id, name, email, country from users where country like concat('%' , ? ,'%') order by name;

-- findById 
delimiter //
create procedure find_user_by_id (in id int)
begin
select id, name, email, country from users where users.id = id;
end //
delimiter ;

call find_user_by_id (?);

-- add 
delimiter //
create procedure insert_user (
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50))
begin
insert into users(name, email, country) values(user_name, user_email, user_country);
end //
delimiter ;

call insert_user(?,?,?);

-- list 
delimiter //
create procedure list_user (in user_country varchar(45))
begin
select * from users where country like concat('%' , user_country ,'%') order by name;
end //
delimiter ;

call list_user (?);


-- update 
delimiter //
create procedure update_user (
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50),
in user_id int)
begin
update users
set name = user_name, email = user_email, country = user_country 
where id = user_id;
end //
delimiter ;

call update_user(?, ?, ?, ?);


-- delete 
delimiter //
create procedure delete_user (in user_id int)
begin
delete from users where id = user_id;
end //
delimiter ;

call delete_user (?);

create table Permision(

id int(11) primary key,

name varchar(50)

);

create table User_Permision(

permision_id int(11),

user_id int(11)

);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');
