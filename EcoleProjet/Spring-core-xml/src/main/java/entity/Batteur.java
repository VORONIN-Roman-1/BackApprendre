package entity;

import service.PrepareService;

public class Batteur implements Musicien {
    private PrepareService prepareService;
    private String emailAddresse;
    private String site;

    //init-method
    public void myInitMethod() {
        System.out.println("Batteur : à l'intérieur de ma methode myinitMethod");
    }
    //destroy method
    public void myDestroyMethod() {
        System.out.println("Batteur : à l'intérieur de ma methode myDestroyMethod");
    }
    public String getEmailAddresse() {
        return emailAddresse;
    }
    public void setEmailAddresse(String emailAddresse) {
        System.out.println("Batteur : à l'intérieur de la méthode set - setEmailAddresse" );
        this.emailAddresse = emailAddresse;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        System.out.println("Batteur : à l'intérieur de la méthode set - setSite");
        this.site = site;
    }
    @Override
    public String joueTaPartition() {
        return "je joue les tambours du Bronx";
    }

    @Override
    public String getPrepa() {
        return prepareService.getPreparation();
    }

    public Batteur() {
        System.out.println("Batteur : à l'intérieur du constructeur sans paramètre");
    }

    public void setPrepareService(PrepareService unService) {
        System.out.println("Batteur : à l'intérieur de la méthode set - setPrepareService()");
        this.prepareService = unService;
    }
}
