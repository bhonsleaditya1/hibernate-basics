package com.spring.oneToMany.demo;

import com.spring.oneToMany.entity.Course;
import com.spring.oneToMany.entity.Instructor;
import com.spring.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourse {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("oneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            // use session object to save Java Object

            //start transaction
            session.beginTransaction();
            //get instructor from db
            int id = 2;
            Instructor instructor = session.get(Instructor.class,id);
            // create some course
            Course course1 = new Course("Guitar");
            Course course2 = new Course("Masterclass");
            // add courses to instructor
            instructor.add(course1);
            instructor.add(course2);
            //save the courses
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
