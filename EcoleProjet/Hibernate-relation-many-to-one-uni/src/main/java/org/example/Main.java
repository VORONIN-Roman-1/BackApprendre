package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Operation;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Voiture.class)
                .addAnnotatedClass(Moteur.class)
                .addAnnotatedClass(Intervention.class)
                .addAnnotatedClass(Operation.class)
                .buildSessionFactory();
        // déclarer session
        Session session = null;
        try {
            // récupérer une session & ouvrir une transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
//récupérer un objet Intervention
            int id = 4;
            Intervention i=session.get(Intervention.class, id);
//affiche l'intervention
            System.out.println("l'intervention : "+i);
//affiche les operations associées
            System.out.println("operations : "+i.getOperations());
//commit transaction
            session.getTransaction().commit();
// fermer la session
            session.close();
            System.out.println("\n______________Session est fernée \n");
            System.out.println("______________Terminé !");


        } finally {

            factory.close();
        }
    }
}