package com.agency04.sbss.pizza.api;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final PizzaDeliveryService pizzaDeliveryService;

    @Autowired
    public CustomerController(PizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username) {
        return pizzaDeliveryService.getCustomer(username);
    }

    @PostMapping("/customer")
    public ResponseEntity<HttpStatus> postCustomer(@RequestBody Customer customer) {
        return pizzaDeliveryService.postCustomer(customer);
    }

    @PutMapping("/customer")
    public ResponseEntity<HttpStatus> putCustomer(@RequestBody Customer customer) {
        return pizzaDeliveryService.putCustomer(customer);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String username) {
        return pizzaDeliveryService.deleteCustomer(username);
    }
}
