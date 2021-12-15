package com.spring.eagerToLazy.demo;

import com.spring.eagerToLazy.entity.Course;
import com.spring.eagerToLazy.entity.Instructor;
import com.spring.eagerToLazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazy {
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
            System.out.println("Debug: Instructor: "+instructor);

            System.out.println("Debug: Courses: "+ instructor.getCourses());
            // commit transaction
            session.getTransaction().commit();

            session.close();
            System.out.println("\nDebug: Session is closed");
            //get course for instructor
            System.out.println("Debug: Courses: "+ instructor.getCourses());
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
