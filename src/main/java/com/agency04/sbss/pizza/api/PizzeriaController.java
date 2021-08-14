package com.agency04.sbss.pizza.api;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PizzeriaController {

    private final PizzeriaService pizzeriaService;

    @Autowired
    public PizzeriaController(PizzaDeliveryService pizzaDeliveryService) {
        this.pizzeriaService = pizzaDeliveryService.getPizzeriaService();
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
