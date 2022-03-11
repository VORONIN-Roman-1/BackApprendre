package com.example.springbootrest;

import com.example.springbootrest.dao.MessageDao;
import com.example.springbootrest.entity.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SpringBootRestApplicationTests {

    @Autowired
    private MessageDao dao;
    @Test
    void contextLoads() {
    }
    @Test
    @DisplayName("findAll Message test 1")
    public void test1() {
        System.out.println("on teste la dao findAll");
        for (Message m : dao.findAll())
            System.out.println(m);
    }
    @Test
    @DisplayName("findAll Message test 2")
    public void test2() {
        System.out.println("on teste la dao findAll");
        assertEquals(5, dao.findAll().size(), "le nombre de messages en bdd est erroné.");
    }
}
