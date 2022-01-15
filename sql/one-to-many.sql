create table role(
	id serial primary key,
	name varchar(255)
);

create table actors(
	id serial primary key,
	name  varchar(255),
	role_id int references Role(id)
);

insert into role(name) values('
the main role');
insert into actors(name, role_id) VALUES ('Alex', 1);

select * from actors;

select * from role where id in (select id from actors);


