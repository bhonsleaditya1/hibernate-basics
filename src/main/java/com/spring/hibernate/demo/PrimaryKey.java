package com.spring.hibernate.demo;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        try {
            // use session object to save Java Object

            //create 3  student object
            System.out.println("Creating new student object");
            Student temp1 = new Student("john","doe","john@mail.com");
            Student temp2 = new Student("Swer","sde","swe@mail.com");
            Student temp3 = new Student("ASD","Qwe","qwe@mail.com");
            //start transaction
            session.beginTransaction();
            //save student object
            System.out.println("Saving student ...");
            session.save(temp1);
            session.save(temp2);
            session.save(temp3);
            // commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
