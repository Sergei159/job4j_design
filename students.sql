create table students (
	id serial primary key,
	name varchar(255),
	age int,
	isStudying bool
	);
    
insert into students (
name, age, isStudying) values('Alex', '23','true');
select * from students;
update students set isStudying = 'false';
select * from students;
delete from students;
select * from students;

	

