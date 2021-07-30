package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService() {
        System.out.println(">> PizzaDeliveryService: inside no-arg constructor");
    }

    @Autowired
    public PizzaDeliveryService(PizzeriaService pizzeriaService) {
        System.out.println(">> PizzaDeliveryService: inside arg constructor");
        this.pizzeriaService = pizzeriaService;
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        System.out.println(">> PizzaDeliveryService: setter method - setPizzeriaService");
        this.pizzeriaService = pizzeriaService;
    }

    @PostConstruct
    public void doMyStartup() {
        System.out.println(">> PizzaDeliveryService: inside of doMyStartup()");
    }

    @PreDestroy
    public void doMyCleanup() {
        System.out.println(">> PizzaDeliveryService: inside of doMyCleanup()");
    }

    public String orderPizza(Pizza pizza) {
        return "\n" +
                "Name: " + pizza.getName() + "\n" +
                "Ingredients: " + pizza.getIngredients() + "\n";
    }
}
