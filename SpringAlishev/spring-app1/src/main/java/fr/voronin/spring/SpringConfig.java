package fr.voronin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("fr.voronin.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Autowired
    BluzMusic bluzMusic;
    @Autowired
    ClassicalMusic classicalMusic;
    @Autowired
    RockMusic rockMusic;
    @Bean
    public List<Music> musicList(){
        List<Music> musics = new ArrayList<>();
        musics.add(bluzMusic);
        musics.add(classicalMusic);
        musics.add(rockMusic);
        return musics;
    }
}
