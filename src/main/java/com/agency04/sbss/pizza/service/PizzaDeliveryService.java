package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dao.*;
import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    private CustomerRepository customerRepository;

    private CustomerDetailsRepository customerDetailsRepository;

    private DeliveryRepository deliveryRepository;

    private PizzaRepository pizzaRepository;

    private PizzaOrderRepository pizzaOrderRepository;

    public PizzaDeliveryService() {
    }

    @Autowired
    public PizzaDeliveryService(PizzeriaService pizzeriaService,
                                CustomerRepository customerRepository,
                                CustomerDetailsRepository customerDetailsRepository,
                                DeliveryRepository deliveryRepository,
                                PizzaRepository pizzaRepository,
                                PizzaOrderRepository pizzaOrderRepository) {
        this.pizzeriaService = pizzeriaService;
        this.customerRepository = customerRepository;
        this.customerDetailsRepository = customerDetailsRepository;
        this.deliveryRepository = deliveryRepository;
        this.pizzaRepository = pizzaRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public CustomerDetailsRepository getCustomerDetailsRepository() {
        return customerDetailsRepository;
    }

    public DeliveryRepository getDeliveryRepository() {
        return deliveryRepository;
    }

    public PizzaRepository getPizzaRepository() {
        return pizzaRepository;
    }

    public PizzaOrderRepository getPizzaOrderRepository() {
        return pizzaOrderRepository;
    }

    public String orderPizza(Pizza pizza) {
        return "\n" +
                "Name: " + pizza.getName() + "\n" +
                "Ingredients: " + pizza.getIngredients() + "\n";
    }
}
