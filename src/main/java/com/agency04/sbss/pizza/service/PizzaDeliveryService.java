package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService() {
        System.out.println("PizzaDeliveryService: inside no-arg constructor");
    }

    public PizzaDeliveryService(PizzeriaService pizzeriaService) {
        System.out.println("PizzaDeliveryService: inside arg constructor");
        this.pizzeriaService = pizzeriaService;
    }

    @Autowired
    public void setPizzeriaService(@Qualifier("marzia") PizzeriaService pizzeriaService) {
        System.out.println("PizzaDeliveryService: setter method - setPizzeriaService");
        this.pizzeriaService = pizzeriaService;
    }

    public String orderPizza(Pizza pizza) {
        return "Name: " + pizza.getName() + "Ingredients: " + pizza.getIngredients();
    }
}
