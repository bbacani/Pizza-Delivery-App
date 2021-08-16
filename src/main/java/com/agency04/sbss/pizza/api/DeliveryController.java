package com.agency04.sbss.pizza.api;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    private final PizzaDeliveryService pizzaDeliveryService;

    @Autowired
    public DeliveryController(PizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @PostMapping("/delivery/order")
    public ResponseEntity<HttpStatus> postOrder(@RequestBody Delivery delivery) {
        return pizzaDeliveryService.postOrder(delivery);
    }

    @GetMapping("/delivery/list")
    public List<Delivery> getOrders() {
        return pizzaDeliveryService.getOrders();
    }
}
