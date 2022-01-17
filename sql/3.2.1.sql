create database relations;

create table roles(
	id serial primary key,
	name varchar(255)
);

create table users(
    id serial primary key,
    name varchar(255),
	roles_id int references roles(id)
);

create table rules(
    id serial primary key,
    name varchar(255),
	roles_id int references roles(id),
	users_id int references users(id)
);


create table category(
	id serial primary key,
	name varchar(255)
);

create table state(
	id serial primary key,
	name varchar(255)
);

create table items(
	id serial primary key,
	name varchar(255),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table comments(
	id serial primary key,
	name varchar(255),
	items_id int references items(id)
);

create table attach(
	id serial primary key,
	name varchar(255),
	items_id int references items(id)
);



insert into roles(name) values ('the main role');
insert into roles(name) values ('the supporting role');

insert into users(name, roles_id) values ('Alex', 1);
insert into users(name, roles_id) values ('James', 2);

insert into rules(name,roles_id,users_id)
values ('just a rule', 1, 1);
insert into rules(name,roles_id,users_id)
values ('the main rule', 1, 2);


insert into category(name) values ('The first');
insert into state(name) values ('Active');

insert into items(name, users_id, category_id, state_id) values('new item', 2, 1, 1);
insert into comments(name,items_id) values ('URGENT', 1);
insert into attach(name,items_id) values ('photo', 1);


select * from items;
select * from users;
select * from rules;