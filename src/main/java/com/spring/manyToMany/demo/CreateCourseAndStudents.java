package com.spring.manyToMany.demo;

import com.spring.manyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudents {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("oneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            // use session object to save Java Object

            //start transaction
            session.beginTransaction();
            // create course
            Course course = new Course("Game");

            //save the course.. and leverage the cascade
            System.out.println("Saving course: "+course);
            System.out.println(course);

            // create students
            Student student1 = new Student("John","Doe","john@mail.com");
            Student student2 = new Student("Mary","Public","mary@mail.com");

            // add students to course
            course.addStudent(student1);
            course.addStudent(student2);

            // save
            session.save(student1);
            session.save(student2);
            System.out.println("Saving Students: "+course.getStudents());
            session.save(course);

            // commit transaction
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
