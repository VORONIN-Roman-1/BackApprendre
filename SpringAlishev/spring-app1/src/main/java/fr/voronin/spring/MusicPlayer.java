package fr.voronin.spring;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList= new ArrayList<>();
    private String name;
    private  int volume;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

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
}
