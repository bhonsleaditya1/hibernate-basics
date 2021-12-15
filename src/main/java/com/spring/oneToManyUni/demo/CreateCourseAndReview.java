package com.spring.oneToManyUni.demo;

import com.spring.oneToManyUni.entity.Course;
import com.spring.oneToManyUni.entity.Instructor;
import com.spring.oneToManyUni.entity.InstructorDetail;
import com.spring.oneToManyUni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReview {
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
            // create course
            Course course = new Course("Game");
            // add some reviews
            course.addReview(new Review("Great course... "));
            course.addReview(new Review("Cool course... "));
            course.addReview(new Review("WooHoo course... "));
            course.addReview(new Review("Dumb course... "));

            //save the course.. and leverage the cascade
            System.out.println("Saving course");
            System.out.println(course);
            System.out.println(course.getReviews());

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
