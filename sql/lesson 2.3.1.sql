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
    name varchar(255)
);

create table role_rules(
    id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
	);

create table items(
	id serial primary key,
	name varchar(255),
	users_id int references users(id)
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

create table category(
	id serial primary key,
	name varchar(255),
	items_id int references items(id)
);

create table state(
	id serial primary key,
	name varchar(255),
	items_id int references items(id)
);

insert into roles(name) values ('the main role');
insert into roles(name) values ('the supporting role');

insert into users(name, roles_id) values ('Alex', 1);
insert into users(name, roles_id) values ('James', 2);

insert into rules(name)  values ('just a rule');
insert into rules(name) values ('the main rule');

insert into role_rules(roles_id, rules_id) values (1, 2 );
insert into role_rules(roles_id, rules_id) values (1, 1 );
insert into role_rules(roles_id, rules_id) values (2, 1);
insert into role_rules(roles_id, rules_id) values (2, 2);

insert into items(name,users_id) values('new item', 2);
insert into comments(name,items_id) values ('URGENT', 1);
insert into attach(name,items_id) values ('photo', 1);
insert into category(name,items_id) values ('The first', 1);
insert into state(name,items_id) values ('Active', 1);

select * from items;
select * from rules;
select * from users;