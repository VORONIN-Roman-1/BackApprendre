package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.Month;

public class GetInterventionsDeSkipyDemo {
    public static void main(String[] args) {
// create session factory
        SessionFactory factory = new Configuration() .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Voiture.class)
                .addAnnotatedClass(Moteur.class)
                .addAnnotatedClass(Intervention.class)
                .addAnnotatedClass(Operation.class)
                .addAnnotatedClass(Mecanicien.class)
                .buildSessionFactory();
// déclarer session
        Session session = null;
        try {
            // récupérer une session & ouvrir une transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // get le mecanicien S. LeGrandGourou
            Mecanicien skipy = session.get(Mecanicien.class, 3);
            System.out.println("Le mecanicien récupéré est :"+skipy);
            System.out.println("Interventions liées : "+skipy.getInterventions());
            //commit transaction
            session.getTransaction().commit();
        } finally {
            //régler le pb de connection leak
            session.close();
            factory.close();
        }
    }
}
