CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'amazon');
insert into company(id, name) values (2, 'google');
insert into company(id, name) values (3, 'verizon');
insert into company(id, name) values (4, 'Alpine');
insert into company(id, name) values (5, 'target');


insert into person(id, name, company_id) values
	(1, 'Alex', 1),
	(2, 'Serzio', 1),
	(3, 'Max', 1),
	(4, 'Kate', 1);

insert into person(id, name, company_id) values
	(5, 'Alexei', 2),
	(6, 'Sveta', 2),
	(7, 'Ivan', 2),
	(8, 'Mary', 2);

insert into person(id, name, company_id) values (9, 'Dima', 3);

insert into person(id, name, company_id) values
 	(10, 'Egor', 4),
	(11, 'Nastya', 4);

insert into person(id, name, company_id) values
	(12, 'Igor', 5),
	(13, 'Arafic', 5),
	(14, 'John', 5);

/*
В одном запросе получить

- имена всех person, которые не состоят в компании с id = 5;

- название компании для каждого человека.
*/
select person.name, company.name
from company
join person
on  company.id = person.company_id
where company.id != 5;

/*
Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании
(нужно учесть, что таких компаний может быть несколько).
*/


WITH func AS(
	select company.name, count(person) as count
	from company
	join person
	on person.company_id = company.id
	group by company.name
)
select * from func
where func.count = (select max(func.count) from func);

