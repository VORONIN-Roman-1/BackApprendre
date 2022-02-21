package fr.voronin.spring;

public class MusicPlayer {
    private Music music;
    private String name;
    private  int volume;

    public MusicPlayer() {
    }

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public Music getMusic() {
        return music;
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

    public  void  playMusic(){
        System.out.println("Playing "+ music.getSong());
    }
}
