create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('phone', 4000);
insert into devices(name, price) values ('TV', 3000);
insert into devices(name, price) values ('Pad', 2000);
insert into devices(name, price) values ('laptop', 12000);

insert into people(name) values ('Alex'), ('James'), ('Serzio');

insert into devices_people (device_id, people_id) 
values(1,1), (2,1), (3,1), (1,2), (2,2), (4,3), (2,3);

select avg(price) from devices_people join devices on device_id = devices.id;

select dp.people_id, avg(devices.price) 
from devices_people as dp
join devices 
on dp.device_id = devices.id
group by dp.people_id;

select dp.people_id, avg(devices.price) 
from devices_people as dp
join devices 
on dp.device_id = devices.id
group by dp.people_id
having avg(devices.price) > 5000;
