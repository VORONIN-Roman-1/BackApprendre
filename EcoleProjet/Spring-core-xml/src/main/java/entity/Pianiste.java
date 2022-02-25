package entity;

import service.PrepareService;

public class Pianiste implements Musicien{

    private PrepareService service ;
    public Pianiste(PrepareService unService) {
        service = unService;
    }

    @Override
    public String joueTaPartition() {
        return "je joue du piano debout";
    }
    @Override
    public String getPrepa() {
        return service.getPreparation();
    }

}
