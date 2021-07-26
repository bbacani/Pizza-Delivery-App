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

    public void orderPizza(Pizza pizza) {
        System.out.println("Ordering " + pizza.getName() + " from " + pizzeriaService.getName());
        System.out.println(pizzeriaService.makePizza(pizza));
        System.out.println("Order complete - delivering from " + pizzeriaService.getAddress() + "\n");
    }
}
