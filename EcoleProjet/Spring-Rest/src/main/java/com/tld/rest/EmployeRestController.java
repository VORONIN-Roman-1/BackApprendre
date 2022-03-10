package com.tld.rest;

import com.tld.entity.Employe;
import com.tld.exception.EmployeErreurResponse;
import com.tld.exception.EmployeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeRestController {
    private List<Employe> employes;
    // définir le PostConstruct pour charger les données des Employes
    @PostConstruct
    public void loadDatas() {
        employes = new ArrayList<>();
        employes.add(new Employe("Robert", "Mignana"));
        employes.add(new Employe("Veronique", "Nemours"));
        employes.add(new Employe("Alexandra", "loiseau"));
    }
    // définir un end point "/employes" qui sauvegarder un nouvel employe
    @PostMapping("/employes")
    public Employe addEmploye(@RequestBody Employe employe) {
    //simuler la bdd
        employe.setId(employes.size());
        employes.add(employe);
        return employe;
    }
    // définir un end point "/employes" qui retourne une liste d'employes
    @GetMapping("/employes")
    public List<Employe> getEmployes() {
        return employes;
    }
    // définir un end point "/employe/{id}" qui retourne un employe
    @GetMapping("/employes/{id}")
    public Employe getEmploye(@PathVariable(name = "id") int employeId) {
        //verifier que l'id recherché est conforme au nombre d'employés
        if (employeId >= employes.size() || (employeId<0)) {
            throw new EmployeNotFoundException("Employe id non trouvé - "+employeId);
        }
        return employes.get(employeId);
    }

}
