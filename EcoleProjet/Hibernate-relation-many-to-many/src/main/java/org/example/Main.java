package org.example;

import org.example.entity.*;
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
                .addAnnotatedClass(Mecanicien.class)
                .buildSessionFactory();
        // déclarer session
        Session session = null;
        try {
            // récupérer une session & ouvrir une transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // créer un objet Intervention
            Intervention i = new Intervention("Petite Révision", 80.5,"A. Didonk",
                    LocalDateTime.of(2020,Month.OCTOBER,10,10,00,00) );
// save l'intervention
            session.save(i);
//afficher l'intervention sauvegardée
            System.out.println("intervention sauvegardée : "+i);
// créer les mécaniciens
            Mecanicien m1 = new Mecanicien( "Vincent", "David");
            Mecanicien m2 = new Mecanicien("léponge", "Bob");
            Mecanicien m3 = new Mecanicien("LeGrandGourou", "Skipy" );
// ajouter les mecaniciens à l'intervention
            i.add(m1);
            i.add(m2);
            i.add(m3);
// save les mécaniciens
            System.out.println("\n sauvegarde des mécaniciens ...");
            session.save(m1);
            session.save(m2);
            session.save(m3);
            System.out.println("\n mécaniciens sauvegardés : "+i.getMecaniciens());
//affiche les mecaniciens associés
            System.out.println("mecaniciens : "+ i.getMecaniciens());
            //commit transaction
            session.getTransaction().commit();
// fermer la session
            session.close();

        } finally {

            factory.close();
        }
    }
}