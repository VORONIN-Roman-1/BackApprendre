package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // проверка соединения
        String jdbcUrl="jdbc:mysql://localhost:3306/bdd_spring_hibernate_projet?"
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
