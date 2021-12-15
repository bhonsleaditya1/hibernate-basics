package com.spring.oneToMany.demo;

import com.spring.oneToMany.entity.Course;
import com.spring.oneToMany.entity.Instructor;
import com.spring.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourse {
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
            //get course from db
            int id = 1;
            Course course = session.get(Course.class,id);
            System.out.println("Deleting course:"+ course);
            session.delete(course);


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
