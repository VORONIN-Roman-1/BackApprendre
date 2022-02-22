package fr.voronin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.Annotation;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        System.out.println(musicPlayer);
        musicPlayer.playMusicList();

//        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
//        MusicPlayer musicPlayer1 = context.getBean("musicPlayer",MusicPlayer.class);
//        System.out.println(musicPlayer);
//        System.out.println(musicPlayer1);
//        musicPlayer.playMusicList();
        context.close();

    }
}
