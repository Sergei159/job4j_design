create table toyota_cars (
	id serial primary key,
	name text,
	year int,
    h_p int
);

create table honda_cars (
	id serial primary key,
	name text,
	year int,
    h_p int
);

insert into toyota_cars(name, year, h_p)
values ('Camry', 2017, 190);
insert into toyota_cars(name, year, h_p)
values ('Corolla', 2013, 99);
insert into toyota_cars(name, year, h_p)
values ('Highlander', 2016, 249);

insert into honda_cars(name, year, h_p)
values ('Accord', 2007, 190);
insert into honda_cars(name, year, h_p)
values ('Civic', 2013, 140);
insert into honda_cars(name, year, h_p)
values (' CR-V', 2017, 190);


select toyota.name,toyota.id, honda.name,honda.id
from toyota_cars as toyota 
join honda_cars as honda
on toyota.id = honda.id;

select toyota.name,honda.name , toyota.h_p
from toyota_cars as toyota 
join honda_cars as honda
on toyota.h_p = honda.h_p;

select toyota.name,toyota.year, honda.name
from toyota_cars as toyota 
join honda_cars as honda
on toyota.year = honda.year;