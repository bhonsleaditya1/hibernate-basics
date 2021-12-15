\connect hbdatabase hbuser;

DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id SERIAL PRIMARY KEY NOT NULL,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL
);

DROP TABLE IF EXISTS course_student;

CREATE TABLE course_student (
    course_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    PRIMARY KEY (course_id,student_id),
    CONSTRAINT FK_COURSE_05 FOREIGN KEY (course_id)
    REFERENCES course (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_STUDENT FOREIGN KEY (student_id)
    REFERENCES student (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

--SET FOREIGN_KEY_CHECKS = 1;
