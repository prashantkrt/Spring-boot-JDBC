-- automatically it will be picked and executed

create table Student(
id int not null,
name varchar(20) not null,
city varchar(40) not null,
age int not null,
primary key(id)
);

create table Course(
id int not null,
name varchar(20) not null,
primary key(id)
);