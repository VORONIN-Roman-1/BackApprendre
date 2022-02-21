package fr.voronin.spring;

public class ClassicalMusic implements Music {
    public void doMyInit(){
        System.out.println("Doing my initailization");
    }
    public  void doMyDestroy(){
        System.out.println("Doing my destruction");

    }
    @Override
    public String getSong() {
        return "Hung";
    }
}
