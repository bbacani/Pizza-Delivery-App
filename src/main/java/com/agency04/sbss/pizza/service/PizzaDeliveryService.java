package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Order;
import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaDeliveryService {

    private List<Order> orders;

    private PizzeriaService pizzeriaService;

    @PostConstruct
    public void loadData() {
        orders = new ArrayList<>();
    }

    public PizzaDeliveryService() {
    }

    @Autowired
    public PizzaDeliveryService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String orderPizza(Pizza pizza) {
        return "\n" +
                "Name: " + pizza.getName() + "\n" +
                "Ingredients: " + pizza.getIngredients() + "\n";
    }
}
