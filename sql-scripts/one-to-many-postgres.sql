DROP DATABASE IF EXISTS hbdatabase;
DROP USER IF EXISTS hbuser;
CREATE USER hbuser PASSWORD 'hbuser';
CREATE DATABASE hbdatabase;
\connect hbdatabase hbuser;

DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail (
    id SERIAL primary key NOT NULL,
    youtube_channel varchar(128) DEFAULT NULL,
    hobby varchar(45) DEFAULT NULL
);


DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
    id SERIAL PRIMARY KEY NOT NULL,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL,
    instructor_detail_id  BIGINT NOT NULL
    REFERENCES instructor_detail (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS course;

CREATE TABLE course (
    id SERIAL PRIMARY KEY NOT NULL,
    title varchar(128) UNIQUE DEFAULT NULL,
    instructor_id INTEGER DEFAULT NULL
    REFERENCES instructor (id)  ON DELETE NO ACTION ON UPDATE NO ACTION
);
