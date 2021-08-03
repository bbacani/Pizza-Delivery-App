package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PizzaRestController {

    List<Order> orders;
    List<Customer> customers;

    @PostConstruct
    public void loadData() {
        orders = new ArrayList<>();
        customers = new ArrayList<>();

        customers.add(new Customer("marko", "Marko", "Markovic", 25));
        customers.add(new Customer("ivo", "Ivo", "Ivic", 30));
    }

    private final PizzaDeliveryService pizzaDeliveryService;
    private final PizzeriaService pizzeriaService;

    public PizzaRestController(PizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
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

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getUsername().equals(username)).findAny();
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new PizzaException("Username not found");
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<HttpStatus> postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<HttpStatus> putCustomer(@RequestBody Customer cust) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getUsername().equals(cust.getUsername())).findAny();
        if (customer.isPresent()) {
            customer.get().setName(cust.getName());
            customer.get().setSurname(cust.getSurname());
            customer.get().setAge(cust.getAge());
        } else {
            throw new PizzaException("Customer not registered");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String username) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getUsername().equals(username)).findAny();
        customer.ifPresentOrElse(
                (value -> customers.remove(value)),
                () -> { throw new PizzaException("Username not found"); }
        );
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delivery/order")
    public ResponseEntity<HttpStatus> postOrder(@RequestBody DeliveryOrderForm orderForm) {
        Order order = new Order();

        Optional<Customer> customer = customers.stream().filter(c -> c.getUsername().equals(orderForm.getUsername())).findAny();
        customer.ifPresentOrElse(
                (order::setCustomer),
                () -> { throw new PizzaException("Customer not registered"); }
        );

        Optional<Pizza> pizza = pizzeriaService.getPizzas().stream().filter(p -> p.getName().equals(orderForm.getPizza())).findAny();
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

        orders.add(order);
        System.out.println(pizzaDeliveryService.orderPizza(order.getPizza()));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<Order> getOrders() {
        return orders;
    }
}
