/**
4.2. Написать скрипт для выполнения следующих запросов:

1) Извлечение данных, у которых имя name содержит подстроку fish

2) Извлечение данных, у которых сред. продолжительность жизни находится в диапазоне 10 000 и 21 000

3) Извлечение данных, у которых дата открытия не известна (null)

4) Извлечение данных видов, у которых дата открытия раньше 1950 года
*/


create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age,discovery_date)
values('cats', 7300, date '0001-01-01');
insert into fauna(name, avg_age,discovery_date)
values('volves', 4000, date '0050-02-01');
insert into fauna(name, avg_age,discovery_date)
values('horses', 11000, date '0002-01-01');
insert into fauna(name, avg_age,discovery_date)
values('turtles', 15600, date '0003-01-01');
insert into fauna(name, avg_age,discovery_date)
values('fish', 2600, date '0046-03-01');


insert into fauna(name, avg_age)
values('birds', 4600);

select * from fauna;

select *from fauna where name like '%fish%';
select *from fauna where 
avg_age >= 10000 and avg_age <= 21000;
select *from fauna where discovery_date is null;
select *from fauna where discovery_date < '1950.01.01';




