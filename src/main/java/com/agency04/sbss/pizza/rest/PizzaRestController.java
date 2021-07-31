package com.agency04.sbss.pizza.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PizzaRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time server is " + LocalDateTime.now();
    }
}
