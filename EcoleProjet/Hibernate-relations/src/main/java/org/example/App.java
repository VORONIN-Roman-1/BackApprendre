package org.example;

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
                .addAnnotatedClass(Voiture.class).addAnnotatedClass(Moteur.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        Voiture v = new Voiture("logan", "111-aa-11");
        Moteur m = new Moteur(90, "essence", 1500);
        v.setMoteur(m);
//        try {
//               session.beginTransaction();
//            session.save(v);
//
//            session.getTransaction().commit();
//
//        }
//        try {
//            session.beginTransaction();
//            Long id = 1L;
//            Voiture vt = session.get(Voiture.class, id);
//            System.out.println("Voiture trouvée : " + vt);
//            if (vt != null) {
//                System.out.println("Suppression de la voiture : " + v);
//                session.delete(vt);
//            }
//            session.getTransaction().commit();
//        }
            try {
                session.beginTransaction();
                // lire un objet moteur dans la bdd
                Moteur mt = session.get(Moteur.class, 2);
                System.out.println("moteur lu : "+mt);
                System.out.println(" la voiture associée est : "+mt.getVoiture());
                session.getTransaction().commit();
            }
        finally{
            factory.close();
        }

    }
}
