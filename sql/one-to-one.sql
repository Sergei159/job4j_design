create table driver_licence(
    id serial primary key,
    number int
);

create table drivers(
    id serial primary key,
    name varchar(255),
    driver_licence_id int
	references driver_licence(id) unique
);

