package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.Month;

public class DeleteInterventionDemo {
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

            // récupérer une intervention
            int id= 1;
            Intervention i = session.get(Intervention.class, id);
// supprimer une intervention
            if(i!=null) {
                System.out.println("Supression de l'intervention : "+i);
                session.delete(i);
            }
//commit transaction
            session.getTransaction().commit();
            System.out.println("Terminé !");
        } finally {
            session.close();
            factory.close();
        }
    }
}
