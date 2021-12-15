package com.spring.hibernate.demo;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
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

            //create student object
            System.out.println("Creating new student object");
            Student temp = new Student("Daffy","Duck","daff@mail.com");
            //start transaction
            session.beginTransaction();
            //save student object
            System.out.println("Saving student ...");
            System.out.println(temp);
            session.save(temp);
            // commit transaction
            session.getTransaction().commit();
            // find out primary student's id: primary key
            System.out.println("Saved Student. Generated id: "+temp.getId());

            // get new session
            session = factory.getCurrentSession();
            session.beginTransaction();
            // retrieve student based on id: primary key
            System.out.println("Getting student with id:"+temp.getId());
            Student tempRead = session.get(Student.class, temp.getId());
            System.out.println("Get Complete "+ tempRead);
            // commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
