package com.tld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SalutationControleur {
    //afficher le formulaire
    @RequestMapping("/getSalutationForm")
    public String afficheSalutationForm() {
        return "salutation-form";
    }
    @RequestMapping("/postSalutationForm")
    public String traiteSalutationForm(HttpServletRequest request, Model model) {
        String name= request.getParameter("userName");
        model.addAttribute("name", name);
        model.addAttribute("message", "Salut "+ name);
        return "salutation-message";
    }
}
