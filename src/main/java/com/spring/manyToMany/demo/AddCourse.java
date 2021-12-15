package com.spring.manyToMany.demo;

import com.spring.manyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCourse {
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
            // get student mary from db
            int id = 2;
            Student student = session.get(Student.class,id);
            System.out.println("Loaded Student: "+ student);
            System.out.println("Courses: "+student.getCourses());

            // create more courses
            Course course1 = new Course("Speed Cube");
            Course course2 = new Course("Game Dev");
            Course course3 = new Course("Atari");

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);
            course3.addStudent(student);

            // save courses
            System.out.println("Saving Courses: ");
            session.save(course1);
            session.save(course2);

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
