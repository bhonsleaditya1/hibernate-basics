drop database if exists hbstudentdb;
create database hbstudentdb with template=template0 owner=hbstudent;
\connect hbstudentdb;

DROP TABLE IF exists student;

CREATE TABLE student (
  id bigint primary key not null,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL
);

alter default privileges grant all on tables to hbstudent;
alter default privileges grant all on sequences to hbstudent;
GRANT ALL PRIVILEGES ON DATABASE hbstudentdb TO hbstudent;
-- drop sequence if EXISTS student_seq;
-- create SEQUENCE student_seq increment 1 start 1;