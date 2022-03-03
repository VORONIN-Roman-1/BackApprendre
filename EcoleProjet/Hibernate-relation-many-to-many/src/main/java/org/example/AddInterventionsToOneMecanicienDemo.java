package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.Month;

public class AddInterventionsToOneMecanicienDemo {
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
            session = factory.getCurrentSession();
            session.beginTransaction();
            // get le mecanicien S. LeGrandGourou
            Mecanicien skipy = session.get(Mecanicien.class, 3);
            System.out.println("Le mecanicien récupéré est :"+skipy);
            System.out.println("Interventions liées : "+skipy.getInterventions());
// créer plus d'interventions
            Intervention i1= new Intervention("Revision des 130 000km", 205.10,
                    "J. Denovan", LocalDateTime.of(2020, Month.SEPTEMBER,18,10,30,00));
            Intervention i2= new Intervention("Courroie de distribution", 860.70,
                    "J. Denovan",LocalDateTime.of(2020, Month.SEPTEMBER,18,14,00,00));
// ajouter le mecanicien à ces interventions
            i1.add(skipy);
            i2.add(skipy);
// enregistrer les interventions
            System.out.println("\n Enregistrement des Interventions .. ");
            session.save(i1);
            session.save(i2);
//commit transaction
            session.getTransaction().commit();
            session.close();
        } finally {
//régler le pb de connection leak
            session.close();
            factory.close();
        }
    }
}
