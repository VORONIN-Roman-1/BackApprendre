package org.example.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Good implements Rating{
    @Override
    public int getRating() {
        return 2;
    }
    @Override
    public String toString() {
        return String.valueOf( getRating());
    }

}
