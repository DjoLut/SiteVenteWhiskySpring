drop schema whiskyproject;

create schema whiskyProject;

drop table if exists whiskyproject.translation;
drop table if exists whiskyproject.langue;
drop table if exists whiskyproject.commandline;
drop table if exists whiskyproject.whisky;
drop table if exists whiskyproject.categorie;
drop table if exists whiskyproject.whiskyorder;
drop table if exists whiskyproject.persistable_user;

create table whiskyProject.persistable_user(
	username varchar(50) primary key,
    password varchar(60) default null,
    authorities varchar(500) default "ROLE_USER",
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(100) not null,
    adresse varchar(100) not null,
    telephone varchar(30) default null,
    non_expired tinyint(1) default 1,
    non_locked tinyint(1) default 1,
    credentials_non_expired tinyint(1) default 1,
    enabled tinyint(1) default 1
);

create table whiskyproject.whiskyorder(
	id int(65) not null AUTO_INCREMENT,
    dateOrder date not null,
    validity tinyint(1) not null,
    utilisateur varchar(50) not null,
    promotion double,
    totalprice double,
    primary key(id),
    constraint utilisateur foreign key(utilisateur) references whiskyproject.persistable_user(username)
);

create table whiskyproject.categorie( nom varchar(50) primary key);

create table whiskyproject.whisky(
	id int(65) primary key,
    whiskyname varchar(50) not null,
    age int(3),
    selection varchar(50),
    brand varchar(50),
    region varchar(50),
    country varchar(50),
    productiondate int(10),
    alcoholcontent int(3),
    volume int(6) ,
    stockquantity int(5),
    categorie varchar(50),
    img varchar(50),
    price double(10,2),
    promotion double(15,2),
    constraint categorie foreign key(categorie) references whiskyproject.categorie(nom)
);

create table whiskyproject.commandline(
	id int(65) not null AUTO_INCREMENT,
    realprice double(15,2),
    quantity int(3) not null,
    whiskyorder int(65) not null,
    whisky int(65) not null,
    primary key(id),
    constraint whiskyorder foreign key(whiskyorder) references whiskyproject.whiskyorder(id),
    constraint whisky foreign key(whisky) references whiskyproject.whisky(id)
);

create table whiskyproject.langue(
	id varchar(50) primary key
);

create table whiskyproject.translation(
	id int(65) primary key,
	descriptions varchar(12000) not null,
    whiskyid int(65) not null,
    languageid varchar(50) not null,
    constraint whiskyid foreign key(whiskyid) references whiskyproject.whisky(id),
    constraint languageid foreign key(languageid) references whiskyproject.langue(id)
);

