package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    List<Customer> customers;

    private final PizzaDeliveryService pizzaDeliveryService;

    private final PizzeriaService pizzeriaService;

    public DeliveryController(PizzaDeliveryService pizzaDeliveryService,
                              CustomerController customerController) {
        this.pizzaDeliveryService = pizzaDeliveryService;
        this.pizzeriaService = pizzaDeliveryService.getPizzeriaService();
        this.customers = customerController.getCustomers();
    }

    @PostMapping("/delivery/order")
    public ResponseEntity<HttpStatus> postOrder(@RequestBody DeliveryOrderForm orderForm) {
        Order order = new Order();

        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getUsername().equals(orderForm.getUsername()))
                .findAny();

        customer.ifPresentOrElse(
                (order::setCustomer),
                () -> { throw new PizzaException("Customer not registered"); }
        );

        Optional<Pizza> pizza = pizzeriaService.getPizzas().stream()
                .filter(p -> p.getName().equals(orderForm.getPizza()))
                .findAny();

        pizza.ifPresentOrElse(
                (order::setPizza),
                () -> { throw new PizzaException("Pizza not available"); }
        );

        if (pizzeriaService.getSizes().contains(orderForm.getSize())) {
            order.setSize(orderForm.getSize());
        } else {
            throw new PizzaException("Size not available");
        }

        if (orderForm.getQuantity() > 0 && orderForm.getQuantity() <= 10) {
            order.setQuantity(orderForm.getQuantity());
        } else {
            throw new PizzaException("Please insert valid quantity (1-10)");
        }

        pizzaDeliveryService.getOrders().add(order);

        System.out.println(pizzaDeliveryService.orderPizza(order.getPizza()));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<Order> getOrders() {
        return pizzaDeliveryService.getOrders();
    }
}
