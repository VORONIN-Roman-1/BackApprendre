package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
import org.example.entity.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

//жадно загружаем ленивые поля
public class FetchJoinDemo {
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
                //récupérer une voiture
            Long id= 1L;
            Query<Voiture> query= session.createQuery("select v from Voiture v"
                            +" JOIN FETCH v.interventions "
                            +" where v.id=:unId",
                    Voiture.class);
            // set parameter on query
            query.setParameter("unId", id);
            // executer la requête et récupérer une voiture
            Voiture v = query.getSingleResult();

                // afficher la voiture
            System.out.println("______________voiture : "+v);




            // "второй способ"
                // get interventions for a given voiture
                Query<Intervention> query2 = session.createQuery("select i from Intervention i "
                                + "where i.voiture.id=:theVoitureId",
                        Intervention.class);
                query2.setParameter("theVoitureId", id);
                List<Intervention> interventions = query2.getResultList();
                System.out.println("interventions2222222222: " + interventions);


            session.close();
                //afficher les Interventions associées
            System.out.println("______________interventions : "+v.getInterventions());
                //commit transaction
            session.getTransaction().commit();
            System.out.println("______________Terminé !");
        } finally {

            factory.close();
        }
    }
}
