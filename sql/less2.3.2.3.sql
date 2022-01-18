create table type(
	id serial primary key,
	name varchar(255)
);

create table product (
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price int
);


insert into type(name) values
('Молоко'), ('Сыр'), ('Овощи'),
('Фрукты'), ('Хлеб'), ('Мороженое');

insert into product(name, type_id, expired_date, price)
values ('Молоко 0%', 1, date '2022-01-15', 100),
('Молоко 1.5%', 1, date '2022-01-17', 100),
('Молоко 2.5%', 1, date '2022-01-18', 100),
('Молоко 3.5%', 1, date '2022-01-20', 100),
 ('Молоко топленое ', 1, date '2022-01-15', 120);

insert into product(name, type_id, expired_date, price)
values ('Моцарелла', 2, '2022-02-15', 250),
 ('Бри', 2, date '2022-02-10', 300),
 ('Камамбер', 2, date '2022-02-11', 300),
 ('Дорблю', 2, date '2022-02-10', 350),
 ('Рокфор', 2, date '2022-03-10', 600),
 ('Маасдам', 2, date '2022-02-10', 260),
 ('Гауда', 2, date '2022-04-10', 200);

insert into product(name, type_id, expired_date, price)
values ('Картофель', 3, date '2022-01-10', 60),
 ('Помидор', 3, date '2022-01-15', 100),
 ('Морковь', 3, date '2022-01-25', 15),
 ('Свекла', 3, date '2022-01-26', 20);

insert into product(name, type_id, expired_date, price)
values ('Банан', 4, date '2022-01-25', 70),
 ('Мандарин', 4, date '2022-01-27', 60),
 ('Яблоки', 4, date '2022-01-29', 80),
 ('Груши', 4, date '2022-01-28', 90),
 ('Киви', 4, date '2022-01-27', 120),
 ('Апельсин', 4, date '2022-02-28', 60);

insert into product(name, type_id, expired_date, price)
values ('Белый хлеб', 5, date '2022-01-19', 20),
 ('Черный хлеб', 5, date '2022-01-19', 20),
 ('Багет', 5, date '2022-01-16', 40);

insert into product(name, type_id, expired_date, price)
values ('Ванильное мороженое', 6, date '2022-06-01', 120),
 ('Шоколадное мороженое', 6, date '2022-06-01', 120),
 ('Клубничное мороженое', 6, date '2022-06-01', 120);

/* 1. Написать запрос получение всех продуктов с типом "СЫР"*/

select type.name, product.name
from type
join product
on type.id = product.type_id
where type.name = 'Сыр';

/*  2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"*/
select product.name
from product
where product.name like '%мороженое%';

/* 3. Написать запрос, который выводит все продукты, срок годности которых уже истек */
select product.name, product.expired_date
from product
where product.expired_date <= current_date;

/* 4. Написать запрос, который выводит самый дорогой продукт.*/
select product.name, product.price
from product
where product.price = (select max(price) from product);

/* 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.*/

select type.name, count(product.name)
from type
join product
on type.id = product.type_id
group by type.name;

/*  6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"*/

select type.name, product.name
from type
join product
on type.id = product.type_id
where type.name = 'Сыр' or type.name = 'Молоко';

/*  7. Написать запрос, который выводит тип продуктов, которых менее 5  штук.*/

select type.name, count(product.name)
from type
join product
on type.id = product.type_id
group by type.name
having count(product.name) > 5;

/* 8. Вывести все продукты и их тип.*/

select type.name, product.name
from type
join product
on type.id = product.type_id;















