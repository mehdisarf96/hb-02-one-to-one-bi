package com.mehdisarf.hibernate.demo;

import com.mehdisarf.hibernate.demo.entity.Instructor;
import com.mehdisarf.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        try (
                SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .buildSessionFactory();

                Session session = factory.getCurrentSession();
        ) {
            // Begin A Transaction
            session.beginTransaction();

            // Get The InstructorDetail Object
            InstructorDetail detail = session.get(InstructorDetail.class, 1);

            // Print The Instructor Detail
            System.out.println("Details Of The Instructor: " + detail);

            // Print The Associated Instructor
            System.out.println(detail.getInstructor());

            // Commit Transaction.
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
