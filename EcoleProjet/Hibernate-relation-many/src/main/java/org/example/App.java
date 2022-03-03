package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // проверка соединения
//        String jdbcUrl="jdbc:mysql://localhost:3306/bdd_one_to_one_uni?"
//                +"useSSL=false&serverTimezone=UTC";
//        String user="roman";
//        String password = "12345";
//        try {
//            System.out.println("Connecting to database " + jdbcUrl);
//            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
//            System.out.println("Connection MySQL successfull!!");
//        }catch(Exception e) {
//            e.printStackTrace();
//        }

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Voiture.class)
                .addAnnotatedClass(Moteur.class)
                .addAnnotatedClass(Intervention.class)
                .buildSessionFactory();

        try {
            // récupérer une session & ouvrir une transaction
            Session  session = factory.getCurrentSession();
            session.beginTransaction();
// créer des objets
            Voiture v = new Voiture("clio", "444-ddd-44");
            Moteur m = new Moteur(115, "diesel", 1400);
//associer les objets
            v.setMoteur(m);
// sauvegarder la voiture
            System.out.println("voiture : " + v);
            session.save(v);
//commit transaction
            session.getTransaction().commit();
            System.out.println("Terminé !");
        } finally {
            factory.close();
        }

    }
}
