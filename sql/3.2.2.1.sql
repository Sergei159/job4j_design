create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references engine(id)
);

insert into body(name) values
('Full_size'),('SUV'),('Off_road'),
('Pickup_truck'),('Station_wagon'),('Sport_car');

insert into engine(name) values
('V16'),('V12'), ('V10'),('V8'),('V6');

insert into transmission(name) values
('Mechanic'), ('A_series'),('U_series'),('Variator');


insert into cars(name, body_id, engine_id, transmission_id) values
('toyota LC200',3,4,2),
('toyota Camry',1,5,3),
('Hyundai Tuscon',2,3,3),
('Volvo S60R',1,4,1),
('Nissan Frontier',4,2,2),
('Oldsmobile Custom Cruiser',5,5,2);

/*1) Вывести список всех машин и все привязанные к ним детали.*/

select cars.name as Car_name,
body.name as Body_name,
engine.name as Engine_name,
transmission.name as Transmission_name
from cars,body,engine,transmission
where cars.body_id = body.id
and cars.engine_id = engine.id
and cars.transmission_id = transmission.id;

/*2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине,*/

select body.name as Body_name,body.id
from body
where body.id =
(select body.id
from body
except
select cars.body_id
from cars);

select engine.name as Engine_name,engine.id
from engine
where engine.id =
(select engine.id
from engine
except
select cars.engine_id
from cars);

select transmission.name as transmission_name,transmission.id
from transmission
where transmission.id =
(select transmission.id
from transmission
except
select cars.transmission_id
from cars);

