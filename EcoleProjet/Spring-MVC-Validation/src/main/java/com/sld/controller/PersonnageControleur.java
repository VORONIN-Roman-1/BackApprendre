package com.sld.controller;

import com.sld.entity.Personnage;


import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/personnages")
public class PersonnageControleur {
    @RequestMapping("/afficheForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("personnage", new Personnage());
        return "personnage-form";
    }

    @InitBinder ///примочка к валидатору применяет trim к полям и поле из пробелов больше не валидно например в notNUll
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("personnage") Personnage unPersonnage, BindingResult leBindingResult) {
        System.out.println("Nom: |" + unPersonnage.getNom() + "|");
        System.out.println("Binding result: " + leBindingResult);
        if (leBindingResult.hasErrors()) {
            System.out.println("il y a des erreurs retour au formulaire ");
            return "personnage-form";
        } else {
            System.out.println("zéro erreur de validation ");
            return "personnage-vue";
        }
    }
}
