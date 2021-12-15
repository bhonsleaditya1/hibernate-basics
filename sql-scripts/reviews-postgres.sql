\connect hbdatabase hbuser;

DROP TABLE IF EXISTS review;

CREATE TABLE review (
    id SERIAL PRIMARY KEY NOT NULL,
    comment varchar(256) DEFAULT NULL,
    course_id INTEGER DEFAULT NULL REFERENCES course (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);
