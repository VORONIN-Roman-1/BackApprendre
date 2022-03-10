package org.example.entity;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE) //Ordered.HIGHEST_PRECEDENCE
public class Average implements Rating{
    @Override
    public int getRating() {
        return 3;
    }
    @Override
    public String toString() {
        return String.valueOf( getRating());
    }
}
