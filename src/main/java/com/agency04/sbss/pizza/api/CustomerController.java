package com.agency04.sbss.pizza.api;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

        Optional<Customer> customer = pizzaDeliveryService.getCustomerRepository().findById(username);

        if (customer.isEmpty()) {
            throw new PizzaException("Username not found");
        }

        return customer.get();
    }

    @PostMapping("/customer")
    public ResponseEntity<HttpStatus> postCustomer(@RequestBody Customer customer) {

        if (pizzaDeliveryService.getCustomerRepository().existsById(customer.getUsername())) {
            throw new PizzaException("Customer already registered");
        }

        pizzaDeliveryService.getCustomerDetailsRepository().save(customer.getCustomerDetails());

        pizzaDeliveryService.getCustomerRepository().save(customer);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<HttpStatus> putCustomer(@RequestBody Customer customer) {

        if (!pizzaDeliveryService.getCustomerRepository().existsById(customer.getUsername())) {
            throw new PizzaException("Customer not registered");
        }

        CustomerDetails customerDetails = customer.getCustomerDetails();
        customerDetails.setUsername(customer.getUsername());
        customerDetails.setCustomer(customer);

        pizzaDeliveryService.getCustomerDetailsRepository().save(customerDetails);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String username) {

        if (!pizzaDeliveryService.getCustomerRepository().existsById(username)) {
            throw new PizzaException("Username not found");
        }

        pizzaDeliveryService.getCustomerRepository().deleteById(username);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
