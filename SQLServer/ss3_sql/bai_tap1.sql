create database quan_ly_sinh_vien;

use quan_ly_sinh_vien;

create table class_student(
classId int primary key,
className varchar(100),
startDate date,
statusClass int
);

create table student_class(
studentID int primary key,
studenName varchar(255),
address varchar(255),
phone varchar(20),
statusStudent int default(0),
classId int,
foreign key (classId) references class_student(classId)
);

create table subject_class(
subId int primary key,
subName varchar(255),
credit int,
statusSubject int
);

create table mark(
markId int primary key,
subId int,
studentId int,
mark int default(0),
examTimes int,
foreign key(subId) references subject_class(subId),
foreign key (studentId) references student_class(studentId)
);

INSERT INTO class_student
VALUES (1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);

INSERT INTO student_class 
VALUES (1,'Hung', 'Ha Noi', '0912113113', 1, 1),
(2,'Hoa', 'Hai phong','0328473282' ,1, 1),
(3,'Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO subject_class
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

INSERT INTO mark 
VALUES (1, 1,1, 8, 1),
       (2, 2,2,10, 2),
       (3, 2, 3,12, 1);
       
       
 -- Hiển thị tất cả sinh viên có tên bắt đầu bằng ký tự 'h'      
select * from student_class
where studenName like 'h%';

 -- Hiển thị các thông tin lớp học có thời gian bắt đầu bằng tháng 12
 
 select * from class_student
 where Month(class_student.startDate) =12;
 
 -- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
 
select * from subject_class
where 3<= credit <=5;

-- Thay đổi mã lớp (classId) của sinh viên Hung là 2
set sql_safe_updates = 0;
update student_class 
set classId = 2
where studenName ='Hung';
set sql_safe_updates = 1;

 -- Hiển thị các thông tin :StudentName,SubName,Mark.Dữ liệu sắp xếp theo điểm thi(mark) giảm dần, nếu trùng sắp theo tên tăng dần
 
 select studenName.student_class,subName.subject_class,mark.mark from mark
 inner join student_class on mark.studentID=student_class.studentID
 join subject_class on mark.subId
 order by mark.mark desc,student_class.studenName asc;
 select * from student_class;