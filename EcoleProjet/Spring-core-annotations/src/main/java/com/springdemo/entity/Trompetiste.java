package com.springdemo.entity;

import com.springdemo.service.PrepareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class Trompetiste implements Musicien {
    private PrepareService prepareService;
    @Value("${email}")private String email;
    @Value("${site}")private String site;
    @Autowired
    public Trompetiste(@Qualifier("mangerPreparationService") PrepareService prepareService) {
        this.prepareService = prepareService;
    }
    @Override
    public String joueTaPartition() {
        return "la trompête du toril";
    }
    @Override
    public String preparesToi() {
        return prepareService.preparesToi();
    }
    @PostConstruct
    public void myInitMethode() {
        System.out.println(" Trompetiste : à l'intérieur de postConstruct() myInitMethode() est appelée ");
    }
    @PreDestroy
    public void myDestroyMethode() {
        System.out.println(" Trompetiste : à l'intérieur de preDestroy() myDestroyMethode() est appelée ");
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
