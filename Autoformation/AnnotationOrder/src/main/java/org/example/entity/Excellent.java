package org.example.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Excellent implements Rating{
    @Override
    public int getRating() {
        return 1;
    }
    @Override
    public String toString() {
        return String.valueOf( getRating());
    }
}
