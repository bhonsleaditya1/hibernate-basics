drop database if exists hbstudentdb;
drop user if exists hbstudent;
create user hbstudent with password 'password';
create database hbstudentdb with template=template0 owner=hbstudent;
\connect hbstudentdb hbstudent;
alter default privileges grant all on tables to hbstudent;
alter default privileges grant all on sequences to hbstudent;

CREATE TABLE student (
                         id bigint primary key not null,
                         first_name varchar(45) DEFAULT NULL,
                         last_name varchar(45) DEFAULT NULL,
                         email varchar(45) DEFAULT NULL
);
create SEQUENCE hibernate_sequence increment 1 start 1;
-- alter table student add date_of_birth date null;
