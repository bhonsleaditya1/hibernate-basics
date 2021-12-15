package com.spring.hibernate.demo;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            // use session object to save Java Object

            int studentId = 1;
            // find out primary student's id: primary key
            System.out.println("Saved Student. Generated id: "+studentId);
            Student temp = session.get(Student.class,studentId);

            System.out.println("Updating student....");
            temp.setFirstName("Scooby");
            // commit transaction
            session.getTransaction().commit();
            //
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email");
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
