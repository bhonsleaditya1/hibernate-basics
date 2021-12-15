package com.spring.oneToOneBi.demo;

import com.spring.oneToOneBi.entity.Instructor;
import com.spring.oneToOneBi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructor {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("oneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            // use session object to save Java Object

            //start transaction
            session.beginTransaction();

            // get instructor detail object
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);

            // print instructor detail
            System.out.println("instructorDetail:"+instructorDetail);
            System.out.println("associated instructor: "+instructorDetail.getInstructor());

            //delete
            System.out.println("Deleting instructor Detail:"+instructorDetail);
            session.delete(instructorDetail);

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
