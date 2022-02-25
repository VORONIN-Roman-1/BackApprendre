package com.tld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showMainMenu() {
        System.out.println("home is responding ");
        return "main-menu";
    }
    @GetMapping("/home")
    public String showHome() {
        System.out.println("home is responding ");
        return "home";
    }
}
