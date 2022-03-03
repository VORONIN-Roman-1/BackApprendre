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

public class MockOperation {
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
//créer un objet Intervention
            Intervention i= new Intervention("Revision des 30 000km ", 350.45,
                    "O. Kenobi",LocalDateTime.of(2020, Month.AUGUST,18,11,30,00));
            Operation o1= new Operation("vidange huile", 'B',false );
            Operation o2= new Operation("filtre a air", 'A',false );
            Operation o3= new Operation("plaquette avant", 'C',true );
// lier les objets
            i.add(o1);
            i.add(o2);
            i.add(o3);
//sauvegarder l'intervention et cascader les opérations
            System.out.println("Save de l'intervention");
            System.out.println(i);
            System.out.println(i.getOperations());
            session.save(i);
//affiche les operations associées
            System.out.println("operations : "+i.getOperations());
//commit transaction
            session.getTransaction().commit();

        } finally {

            factory.close();
        }
    }
}
