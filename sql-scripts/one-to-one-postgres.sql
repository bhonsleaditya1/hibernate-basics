DROP DATABASE IF EXISTS hbdatabase;
DROP USER IF EXISTS hbuser;
CREATE USER hbuser PASSWORD 'hbuser';
CREATE DATABASE hbdatabase;
\connect hbdatabase hbuser;

--SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail (
  id SERIAL PRIMARY KEY NOT NULL,
  youtube_channel varchar(128) DEFAULT NULL,
  hobby varchar(45) DEFAULT NULL
);


DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
  id SERIAL PRIMARY KEY NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  instructor_detail_id BIGINT REFERENCES instructor_detail(id)
);
-- KEY FK_DETAIL_idx (instructor_detail_id),
--   CONSTRAINT FK_DETAIL FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail (id) ON DELETE NO ACTION ON UPDATE NO ACTION

--SET FOREIGN_KEY_CHECKS = 1;