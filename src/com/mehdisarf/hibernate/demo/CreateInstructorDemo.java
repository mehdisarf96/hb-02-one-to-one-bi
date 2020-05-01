package com.mehdisarf.hibernate.demo;

import com.mehdisarf.hibernate.demo.entity.Instructor;
import com.mehdisarf.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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

            // Create Instructor Object
            Instructor instructor = new Instructor("Franz","Kafka","f.kafka@gmail.com");

            // Create InstructorDetail Object
            InstructorDetail detail = new InstructorDetail("youtube.com/fk","writing");

            // Associate Those Object Together
            instructor.setInstructorDetail(detail);

            // Let's Save Instructor Object
            session.save(instructor);

            // Commit Transaction.
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
