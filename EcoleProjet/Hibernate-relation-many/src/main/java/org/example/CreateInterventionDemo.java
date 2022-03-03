package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.Month;

public class CreateInterventionDemo {
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

            // lire une Voiture
            Long id = 1L;
            Voiture v = session.get(Voiture.class, id);
// créer des interventions
            Intervention i1 = new Intervention("Petite Révision", 80.5, "A.Didonk", LocalDateTime.of(2020, Month.OCTOBER, 10, 10, 00, 00));
            Intervention i2 = new Intervention("Changement des pneus avant", 20., "M. Imome", LocalDateTime.of(2019, Month.DECEMBER, 5, 14, 30, 00));
            Intervention i3 = new Intervention("Vidange", 80.5, "S.Ouraille", LocalDateTime.of(2017, Month.JUNE, 21, 8, 45, 00));
// ajouter ces Interventions à la voiture
            v.add(i1);
            v.add(i2);
            v.add(i3);
// sauvegarder ces interventions
            session.save(i1);
            session.save(i2);
            session.save(i3);

//commit transaction
            session.getTransaction().commit();
            System.out.println("Terminé !");
        } finally {
            session.close();
            factory.close();
        }
    }
}