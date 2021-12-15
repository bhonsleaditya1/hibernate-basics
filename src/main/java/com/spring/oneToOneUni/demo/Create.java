package com.spring.oneToOneUni.demo;

import com.spring.oneToOneUni.entity.Instructor;
import com.spring.oneToOneUni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Create {
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

            // create objects
            Instructor instructor = new Instructor("Abc","DCD","adc@mail.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/abs","Hobby");

            //Instructor instructor = new Instructor("Abcds","DCqwD","adasc@mail.com");
            //InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/aasbs","Hoobby");

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();

            //save the instructor
            // Note: will also save details object
            // because of Cascade.ALL
            System.out.println("Saving Instructor:"+instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
