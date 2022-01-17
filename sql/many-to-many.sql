 create table students(
     id serial primary key,
     name varchar(255)
 );
 
 create table subjects(
     id serial primary key,
     name varchar(255)
 );
 
 create table subjects_to_pass(
     id serial primary key,
     student_id int references students(id),
     subject_id int references subjects(id)
 );
 
 insert into students(name) values ('Ivan');
insert into students(name) values ('Kirill');
insert into students(name) values ('Roman');

insert into subjects (name) values ('math');
insert into subjects (name) values ('english');
insert into subjects (name) values ('history');

insert into subjects_to_pass (student_id, subject_id) values (1, 1);
insert into subjects_to_pass (student_id, subject_id) values (1, 2);
insert into subjects_to_pass (student_id, subject_id) values (1, 3);
insert into subjects_to_pass (student_id, subject_id) values (2, 1);
insert into subjects_to_pass (student_id, subject_id) values (2, 2);
insert into subjects_to_pass (student_id, subject_id) values (3, 3);

select * from subjects_to_pass;