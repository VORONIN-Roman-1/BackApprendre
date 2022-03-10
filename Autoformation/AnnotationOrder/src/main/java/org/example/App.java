package org.example;

import org.example.entity.Average;
import org.example.entity.ListRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context =new
                ClassPathXmlApplicationContext("applicationContext.xml");
                // accéder au bean géré par le spring container
        ListRating listRating=
                context.getBean(ListRating.class);
        System.out.println(listRating);
    }
}
