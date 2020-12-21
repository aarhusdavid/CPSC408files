/Users/DavidAarhus/Documents/CPSC 408/RADDL.sql-- Rational Algebra wksheet
Supplier(sid, sname, address)
Part(pid, pname, color)
Catalog(sid, pid, cost)

--DDL Data definition language
create table Supplier(
    sid integer not null primary key,
    sname varchar(50),
    address varchar(100)
);

create table Part(
    pid integer not null primary key,
    pname varchar(50),
    color varchar(20)
);

create table Catalog(
    sid integer not null foreign key references Supplier(sid),
    pid integer not null foreign key references Part(pid),
    cost numeric,
    primary key (sid, pid)
);

-- DML Data manipulation language
insert into Supplier values(1,'Home Depot', '122 Dr');
insert into Part values(10,'Drill Bit', 'titanium');
insert into Catalog values(1,10,5.5);

-- Read / Query
select max(cost) from Catalog;
select min(cost) from Catalog;
select avg(cost) from Catalog;
select count(*) from Supplier;
select avg(cost) as average from Catalog;
select cost as price from Catalog;
select cost from Part p, Catalog c where p.pid=c.pid and color = 'red';
select c1.sid from Catalog c1, Catalog c2 where c1.pid=c2.pid and c1.sid<>c2.sid and c1.cost > c2.cost;
select sid from Supplier;
select count(distinct sid) from Catalog where cost > 100;
select pname from Part where pname = 'hammer';
select pname from Part where pname like'_h%'; --select names that have 'h' as their second letter
select pname from Part where pname like'h%h'; --select names that start end with 'h';
--projection (select keyword)
select sname from Supplier; --returns every Supplier name in Supplier database
select * from Supplier; -- returns every tuple in Supplier database
select sid,sname from Supplier -- returns every name and id in Supplier database

--Selection (where)
select pid,pname from Part where color 'red';
select pid,cost from Catalog where cost > 10;
select pid,cost from Catalog where cost > and cost < 100;
select pname from Part where color = 'red' or color = 'blue';

--cost of every red Part
select cost from Part,Catalog where Part.pid=Catalog.pid and color = 'red';
select cost from Part natural join Catalog where color = 'red';

--first 5 queries as sql statements
select sname from Supplier natural join Catalog natural join Part where color = 'red';
select sid from Catalog natural join Part where color = 'red' or color = 'green';
select sid from Supplier natural join Catalog natural join Part where color = 'red' or address = '21 George Street';
select sname from Supplier natural join Catalog natural join Part where color ='red' or address = '21 George Street';
select sname from Supplier natural join Catalog natural join Part where color ='red' and color = 'green';


create table Faculty
(
    ss integer primary key,
    name varchar(50),
    specialty varchar(50),
    salary numeric,
    passkey varchar(10)
)
