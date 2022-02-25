package com.springdemo.service;

import org.springframework.stereotype.Component;

@Component
public class ZenPreparationService implements PrepareService {
    @Override
    public String preparesToi() {
        return "je respire calmement, et je me détend";
    }
}