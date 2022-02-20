
/*  Выполнить запросы с left, right, full, cross соединениями
*/



create table departments (
	id serial primary key,
	name varchar(255)
);

create table employers (
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(name) values
('Management'), ('Accounting'), ('Design'), ('Calculation');

insert into employers(name,department_id) values
('Alex', 1), ('James', 1), ('Sophia', 1), 
('Oleg', 2), ('Olga', 2), 
('Sezio', 3), ('Jin', 3), ('Kate', 3),('Dora', 3);

/*Выполнить запросы с left, rigth, full, cross соединениями*/

select * from departments d
left join employers e 
on d.id = e.department_id;

select * from departments d
right join employers e 
on d.id = e.department_id;

select * from departments d
full join employers e 
on d.id = e.department_id;

select * from departments d
cross join employers e;


/* Используя left join найти департаменты, у которых нет работников
//
*/
select * from departments d
left join employers e 
on d.id = e.department_id
where e.department_id is null;

/*Используя left и right join написать запросы, которые давали бы одинаковый результат*/

select d.name, e.name from departments d
left join employers e 
on d.id = e.department_id;

select d.name, e.name from employers e 
right join departments d 
on d.id = e.department_id;

/*///////*/

select e.name, d.name from employers e 
left join departments d
on d.id = e.department_id;

select e.name, d.name from departments d  
right join employers e
on d.id = e.department_id;

/*Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары*/

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values
('Alex', 'M'), ('James', 'M'), ('Oleg', 'M'), ('Serzio', 'M'),
('Sophia', 'F'), ('Kate', 'F'), ('Mary', 'F');

select * from teens as first
cross join  teens as second
where first.gender != second.gender;