package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Operation;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteCascade {
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
//supprimer l'intervention
            System.out.println("Suppression de l'intervention : "+i );
            session.delete(i);
//commit transaction
            session.getTransaction().commit();
// fermer la session
            session.close();
            System.out.println("\n______________Session est fernée \n");
            System.out.println("______________ Terminé !");
        } finally {

            factory.close();
        }
    }
}