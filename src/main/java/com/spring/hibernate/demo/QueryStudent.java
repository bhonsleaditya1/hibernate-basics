package com.spring.hibernate.demo;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        try (factory) {
            Session session = factory.getCurrentSession();
            // use session object to save Java Object
            //start transaction
            session.beginTransaction();

            //query students
            List<Student> students = session.createQuery("from Student").getResultList();
            // display students
            displayStudents(students);

            // query students lastName= 'doe'
            students = session.createQuery("from Student s where s.lastName='doe'").getResultList();

            System.out.println("\nStudents that have last name of doe");
            displayStudents(students);

            // query students lastName='doe' or firstName='Daffy'
            students = session.createQuery("from Student s where s.lastName='doe'" +
                    "or firstName='Daffy'").getResultList();

            System.out.println("\nStudents that have last name of doe or firstname of daffy");
            displayStudents(students);

            students = session.createQuery("from Student s where s.email like '%mail.com'").getResultList();

            System.out.println("\nStudents whoose email ends with mail.com");
            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student temp : students)
            System.out.println(temp);
    }
}
