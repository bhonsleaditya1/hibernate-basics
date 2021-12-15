package com.spring.oneToOne.demo;

import com.spring.oneToOne.entity.Instructor;
import com.spring.oneToOne.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Delete {
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

            // egt constuctor by primary key/id
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);
            System.out.println("Found Instructor: "+ instructor);

            if(instructor!=null){
                System.out.println("Deleting: "+ instructor);

                // Note: will also delete associated "details" object
                // CascadeType.ALL
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
