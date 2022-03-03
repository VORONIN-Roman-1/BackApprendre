package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
// create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Voiture.class)
                .addAnnotatedClass(Moteur.class)
                .addAnnotatedClass(Intervention.class)
                .buildSessionFactory();
// déclarer session
        Session session = null;
        try {
// récupérer une session & ouvrir une transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
//récupérer une voiture
            Long id= 1L;
            Voiture v = session.get(Voiture.class , id);
// afficher la voiture
            System.out.println("______________voiture : "+v);
//afficher les Interventions associées
            System.out.println("______________interventions : "+v.getInterventions());
//commit transaction
            session.getTransaction().commit();
            System.out.println("______________Terminé !");
        } finally {
            session.close();
            factory.close();
        }
    }
}

