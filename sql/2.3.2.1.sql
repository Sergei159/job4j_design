/**

1. Придумать две таблицы и связь между ними

2. Написать 3 запроса с inner join с использованием альясов


*/
create table driver_licence(
    id serial primary key,
	series int,
    number int
);

create table driver(
    id serial primary key,
    name varchar(255),
    driver_licence_id int
	references driver_licence(id) unique
);

insert into driver_licence(series, number)
values (5777, 950449);
insert into driver_licence(series, number)
values (5778, 950450);
insert into driver_licence(series, number)
values (5779, 950451);



insert into driver(name, driver_licence_id)
values('Sergei', 1);
insert into driver(name, driver_licence_id)
values('Alex', 2);
insert into driver(name, driver_licence_id)
values('James', 3);
insert into driver(name) values('Aron');
insert into driver(name) values('Shanom');

select driver.name, l.series,l.number
from driver as driver
join driver_licence as l
on driver.id = l.id;

select driver.name,
l.series || ' ' || l.number "driver licence"
from driver as driver
join driver_licence as l
on driver.id = l.id;

select l.series, driver.name
from driver_licence as l
join driver as driver
on driver.id = l.id;