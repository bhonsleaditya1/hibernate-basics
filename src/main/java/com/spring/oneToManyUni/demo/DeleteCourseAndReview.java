package com.spring.oneToManyUni.demo;

import com.spring.oneToManyUni.entity.Course;
import com.spring.oneToManyUni.entity.Instructor;
import com.spring.oneToManyUni.entity.InstructorDetail;
import com.spring.oneToManyUni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReview {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("oneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            // use session object to save Java Object

            //start transaction
            session.beginTransaction();

            // get course
            int id = 4;
            Course course = session.get(Course.class,id);

            //print course
            System.out.println("Deleting Course..");
            System.out.println(course);
            //print reviews
            System.out.println(course.getReviews());

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
