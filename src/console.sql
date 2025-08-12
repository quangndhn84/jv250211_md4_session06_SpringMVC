Create database StudentManagement;
use StudentManagement;
create table Student(
    student_id int primary key auto_increment,
    student_name varchar(150) not null,
    student_age int not null,
    student_status bit default (1)
);
DELIMITER &&
create procedure find_all_student()
begin
    select * from Student;
end &&
create procedure find_student_by_id(id_in int)
begin
    select * from Student where student_id = id_in;
end &&
create procedure create_student(
    name_in varchar(150),
    age_in int
)
begin
    insert into Student(student_name, student_age)
        values(name_in,age_in);
end &&
create procedure update_student(
    id_in int,
    name_in varchar(150),
    age_in int,
    status_in bit
)
begin
    update Student
        set student_name = name_in,
            student_age = age_in,
            student_status = status_in
    where student_id = id_in;
end &&
create procedure delete_student(id_in int)
begin
    delete from Student where student_id = id_in;
end &&
DELIMITER &&