package entity;

import service.PrepareService;

public class Violoniste implements Musicien {

    private PrepareService service ;
    public Violoniste(PrepareService unService) {
        service = unService;
    }
    @Override
    public String joueTaPartition(){
        return "je joue de la Valse d'Amélie";
    }
    @Override
    public String getPrepa() {
        return service.getPreparation();
    }
}