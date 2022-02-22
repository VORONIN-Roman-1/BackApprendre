package fr.voronin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MusicPlayer {
    @Autowired
    private List<Music> musicList= new ArrayList<>();
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private  int volume;

//    @Autowired
//    public MusicPlayer(List<Music> musicList) {
//        this.musicList = musicList;
//    }

    public String getName() {
        return name;
    }



    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void  playMusicList(){
        for (Music music: musicList
             ) {
            System.out.println("Playing "+ music.getSong());
        }

    }

    @Override
    public String toString() {
        return "MusicPlayer{" +
                ", name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }
}
