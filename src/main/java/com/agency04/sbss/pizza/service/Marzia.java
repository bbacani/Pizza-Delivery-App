package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary
@Service
public class Marzia implements PizzeriaService {

    @Value("${foo.name}")
    private String name;

    @Value("${foo.address}")
    private String address;

    @Value("${foo.number}")
    private String number;

    private String motto;

    @PostConstruct
    public void doMyStartup() {
        System.out.println(">> Marzia: inside of doMyStartup()");
        this.motto = "Best pizza in Italy!";
    }

    @PreDestroy
    public void doMyCleanup() {
        System.out.println(">> Marzia: inside of doMyCleanup()");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String makePizza(Pizza pizza) {
        return getName() + ": Making " + pizza.getName() + "\n";
    }
}
