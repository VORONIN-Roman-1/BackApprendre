package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListRating {
    @Autowired
    //@Qualifier("excellent")
    Rating rating;
    // Rating good;  //создаст именно бит good  если нету @Qualifier

    @Autowired
    List<Rating> ratings;
    @Override
    public String toString() {
        return "ListRating{" +
                "average=" + rating.getRating() +
                "\nlist: "+ratings.toString()+
                '}';
    }

}
