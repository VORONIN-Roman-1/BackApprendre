package com.springdemo;

import com.springdemo.entity.Musicien;
import com.springdemo.entity.Trompetiste;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MonApplication {
    public static void main(String[] args) {
        //charger le fichier de configuration xml
        ClassPathXmlApplicationContext context =new
                ClassPathXmlApplicationContext("applicationContext.xml");
        // accéder au bean géré par le spring container
        Trompetiste musicien=
                context.getBean("trompetiste", Trompetiste.class);
        // utiliser les methode de musicien
        System.out.println(musicien.joueTaPartition());
        System.out.println(musicien.preparesToi());
        System.out.println(musicien.getEmail());
        System.out.println(musicien.getSite());
        // fermer le context
        context.close();
    }
}
