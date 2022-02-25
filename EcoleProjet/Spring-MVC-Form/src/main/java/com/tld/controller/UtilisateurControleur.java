package com.tld.controller;

import com.tld.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UtilisateurControleur {
    @Value("#{paysListe}")
    private Map<String, String> paysListe;

    @Value("#{osOptions}")
    private Map<String, String> osOptions;

    @RequestMapping("/")
    public String afficherHello(){
        return "main-menu";
    }
    @RequestMapping("/afficheUtilisateurForm")
    public String afficheForm(Model leModel) {
        leModel.addAttribute("utilisateur", new Utilisateur());
        leModel.addAttribute("laListeDesPays", paysListe);
        leModel.addAttribute("osOptions", osOptions);
        return "utilisateur-form";
    }
    @RequestMapping("/processForm")
    public String processForm(
            @ModelAttribute("utilisateur") Utilisateur unUtilisateur){
//log la donnée entrante unUtilisateur.getNom();
        return "utilisateur-vue";
    }
}