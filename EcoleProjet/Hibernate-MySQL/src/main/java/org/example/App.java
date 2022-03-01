package org.example;

import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // проверка соединения
//        String jdbcUrl="jdbc:mysql://localhost:3306/bdd_hibernate_demo?"
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
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // debut de transaction
            session.beginTransaction();
            // Lister les voitures
            List<Voiture> voitures=session
                            .createQuery("from Voiture ")
                            .getResultList();
                //Afficher les voitures
            System.out.println("1- All voitures : ");
            voitures.stream().forEach(System.out::println);
            System.out.println("\n");

            Long id= 1L;
            //lire ou récupérer une voiture avec son id: clé primaire
            Voiture uneVoiture =
                    session.get(Voiture.class, id);
            //modifier le modèle de la voiture
            System.out.println("mise à jour de la voiture...");
            uneVoiture.setModele("Zoe");

            // commit de la transaction
            session.getTransaction().commit();
            System.out.println("Terminé !");
        } finally {
            factory.close();
        }
//        try {
//
//            Voiture voitureTemp = new Voiture("clio", "AK-725-66");
//            Voiture voitureTemp1= new Voiture("picasso", "CDF-548-13");
//            Voiture voitureTemp2= new Voiture("countach", "ZE-022-13");
//            Voiture voitureTemp3= new Voiture("kangoo", "Zg-047-84");
//              // debut de trasaction
//            session.beginTransaction();
//                // save la voiture
//            session.save(voitureTemp);
//            // save la voiture
//            session.save(voitureTemp1);
//            session.save(voitureTemp2);
//            session.save(voitureTemp3);
//              // commit de la transaction
//            session.getTransaction().commit();
//            System.out.println("voiture sauvegardée . son id généré: "+voitureTemp.getId());
//              //récupérer une nouvelle session et ouvrir une transaction
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//                //lire ou récupérer une voiture avec son id: clé primaire
//            System.out.println("\nRecupérer la voiture avec l'id : "+voitureTemp.getId());
//            Voiture voitureSaved = session.get(Voiture.class, voitureTemp.getId());
//            System.out.println("Get Terminé : "+voitureSaved);
//                //commit transaction
//            session.getTransaction().commit();
//            System.out.println("Terminé !");
//        } finally {
//            factory.close();
//        }
    }
}
