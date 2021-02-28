drop database redsun;
drop table gas_exchange;
drop table gas;

create database redsun default character set utf8mb4;

use redsun;

create table gas(
    id int(11) primary key auto_increment,
    year int(5),
    month int(5),
    is_null int(2) default 0,
    status int(2) default 0,
    create_time Datetime,
    modify_time DATETIME
);

create table gas_exchange(
    id int(11) primary key auto_increment,
    ex_time int(11),
    input_id int(11),
    output_id int(11),
    guest_id int(11),
    money float(5),
    remark varchar(255)
);

create table guest(
    id int(11) primary key auto_increment,
    name varchar(100),
    address varchar(255),
    phone varchar(100)
);

create table null_gas(
    id int(11) primary key auto_increment,

)