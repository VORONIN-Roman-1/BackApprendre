package org.example;

import org.example.entity.Intervention;
import org.example.entity.Moteur;
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
        String jdbcUrl="jdbc:mysql://localhost:3306/bdd_many_to_many?"
                +"useSSL=false&serverTimezone=UTC";
        String user="roman";
        String password = "12345";
        try {
            System.out.println("Connecting to database " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection MySQL successfull!!");
        }catch(Exception e) {
            e.printStackTrace();
        }



    }
}
