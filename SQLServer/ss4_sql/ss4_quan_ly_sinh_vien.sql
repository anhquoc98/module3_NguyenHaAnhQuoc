use quan_ly_sinh_vien;

select * from class_student;

 -- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select * from subject_class
where credit =
(select max(credit) from subject_class);

 -- Hiển thị các thông tin môn học có điểm thi lớn nhất.
 select * from mark
 where mark=
 (select max(mark) from mark);
 
 -- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, 
-- xếp hạng theo thứ tự điểm giảm dần

select student_class.studentId,studenName,avg(mark) as 'dtb'
from student_class  inner join mark  on student_class.studentId =mark.studentId
group by student_class.studentId
order by 'dtb' desc;