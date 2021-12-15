package com.spring.hibernate.demo;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
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
            int studentId = 1;
            //Student temp = session.get(Student.class,studentId);
            //delete student
            //System.out.println("Deleting student: "+temp);
            //session.delete(temp);

            // delete student id = 2
            System.out.println("Deleting student where id=2");
            session.createQuery("delete from Student where id = 2").executeUpdate();

            // commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
