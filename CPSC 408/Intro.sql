Owner(oid, name, address, age)
Food(fid, fname, calories)
Pet(pid, owner_id, pname, age, species, favFood, weight)

-- DDL - data definition language
create table Owner(
    oid integer not null primary key,
    name varchar(50),
    address varchar(100),
    age integer,
);

create table Food(
    fid integer not null primary key,
    fname varchar(20),
    calories numeric
);

create table Pet(
    pid integer not null primary key,
    oid integer foreign key references Owner(oid),
    pname varchar(50),
    age integer,
    species varchar(20),
    fid integer foreign key references Food(fid),
    weight numeric
);

insert into Owner values(1,'Eric','One University Drive', 40);
insert into Owner values(2,'Rene','Two University Drive', 38);
insert into Owner(oid, name) values(3, 'Fahy'); -- NULL if not specified

insert into Food values(100,'beef',250);
insert into Food values(200,'chicken',150);

insert into Pet values(50,1,'Scout',17,'Dog',200,25);




-- examples of data.sql outputs
-- department1 = (employee1,'sales rep','Sales')
-- department2 = (employee22,'customer service rep','Customer Service')
