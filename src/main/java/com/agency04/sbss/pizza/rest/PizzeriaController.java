package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.MenuResponse;
import com.agency04.sbss.pizza.model.PizzeriaResponse;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzeriaController {

    List<Customer> customers;

    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzaDeliveryService pizzaDeliveryService,
                              CustomerController customerController) {
        this.pizzeriaService = pizzaDeliveryService.getPizzeriaService();
        this.customers = customerController.getCustomers();
    }

    @GetMapping("/pizzeria/menu")
    @ResponseBody
    public MenuResponse getMenu() {
        MenuResponse menu = new MenuResponse();

        menu.setPizzas(pizzeriaService.getPizzas());
        menu.setSizes(pizzeriaService.getSizes());

        return menu;
    }

    @GetMapping("/pizzeria")
    @ResponseBody
    public PizzeriaResponse getPizzeria() {
        PizzeriaResponse pizzeria = new PizzeriaResponse();

        pizzeria.setName(pizzeriaService.getName());
        pizzeria.setAddress(pizzeriaService.getAddress());
        pizzeria.setNumber(pizzeriaService.getNumber());

        return pizzeria;
    }
}
