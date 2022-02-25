package com.springdemo.service;

import org.springframework.stereotype.Component;

@Component
public class MangerPreparationService implements PrepareService {
    @Override
    public String preparesToi() {
        return "Mange bourger";
    }
}
