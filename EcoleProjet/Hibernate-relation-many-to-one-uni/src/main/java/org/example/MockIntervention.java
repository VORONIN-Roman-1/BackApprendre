package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Operation;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class MockIntervention {
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
// créer des objets
            Voiture v= new Voiture("clio", "444-ddd-44");
            Moteur m = new Moteur (115, "diesel",1400);
            Intervention i1= new Intervention("Petite Révision", 80.5,"A. Didonk", LocalDateTime.of(2020, Month.OCTOBER,10,10,00,00) );
            Intervention i2= new Intervention("Changement des pneus avant", 20. ,"M.Imome",LocalDateTime.of(2019,Month.DECEMBER,5,14,30,00) );
            Intervention i3= new Intervention("Vidange", 80.5,"S. Ouraille",LocalDateTime.of(2017,Month.JUNE,21,8,45,00) );
            v.setMoteur(m);
            v.add(i1);
            v.add(i2);
            v.add(i3);
// sauvegarder ces interventions
            session.save(i1);
            session.save(i2);
            session.save(i3);
            session.save(v);
//commit transaction
            session.getTransaction().commit();
            System.out.println("Terminé !");

        } finally {

            factory.close();
        }
    }
}
