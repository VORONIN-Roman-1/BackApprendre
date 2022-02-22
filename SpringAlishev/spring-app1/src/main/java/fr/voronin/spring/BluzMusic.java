package fr.voronin.spring;

import org.springframework.stereotype.Component;

@Component
public class BluzMusic implements Music{
    @Override
    public String getSong() {
        return "Saxophone";
    }
}
