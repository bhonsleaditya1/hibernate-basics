package com.spring.hibernate.demo;

import com.spring.hibernate.entity.Student;
import com.spring.hibernate.utils.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudent {
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
            String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

            Student temp = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);
            //start transaction
            session.beginTransaction();
            //save student object
            System.out.println("Saving student ...");
            session.save(temp);
            // commit transaction
            session.getTransaction().commit();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }
}
