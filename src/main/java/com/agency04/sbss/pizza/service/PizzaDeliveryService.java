package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.api.PizzaException;
import com.agency04.sbss.pizza.dao.*;
import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void setPizzas() {

        for (Pizza pizza : pizzeriaService.getPizzas()) {
            pizza.setIngredients(pizza.getIngredients());
            pizzaRepository.save(pizza);
        }
    }

    public void saveCustomers(List<Customer> customers) {

        for (Customer customer : customers) {
            customerDetailsRepository.save(customer.getCustomerDetails());
        }

        customerRepository.saveAll(customers);
    }

    public Customer getCustomer(String username) {

        Optional<Customer> customer = customerRepository.findById(username);

        if (customer.isEmpty()) {
            throw new PizzaException("Username not found");
        }

        return customer.get();
    }

    public ResponseEntity<HttpStatus> postCustomer(Customer customer) {

        if (customerRepository.existsById(customer.getUsername())) {
            throw new PizzaException("Customer already registered");
        }

        customerDetailsRepository.save(customer.getCustomerDetails());

        customerRepository.save(customer);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> putCustomer(Customer customer) {

        if (!customerRepository.existsById(customer.getUsername())) {
            throw new PizzaException("Customer not registered");
        }

        CustomerDetails customerDetails = customer.getCustomerDetails();
        customerDetails.setUsername(customer.getUsername());
        customerDetails.setCustomer(customer);

        customerDetailsRepository.save(customerDetails);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteCustomer(String username) {

        if (!customerRepository.existsById(username)) {
            throw new PizzaException("Username not found");
        }

        customerRepository.deleteById(username);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> postOrder(Delivery delivery) {

        if (!customerRepository.existsById(delivery.getCustomer().getUsername())) {
            throw new PizzaException("Customer not registered");
        }

        delivery.setSubmissionDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));

        List<PizzaOrder> temp = new ArrayList<>();

        for (PizzaOrder pizzaOrder : delivery.getPizzaOrders()) {
            pizzaOrder.setPizza(pizzaRepository
                    .findById(pizzaOrder.getPizza().getName())
                    .orElseThrow()
            );

            if (pizzaOrder.getQuantity() <= 0 || pizzaOrder.getQuantity() > 10) {
                throw new PizzaException("Please insert valid quantity (1-10)");
            }

            if (!pizzeriaService.getSizes().contains(pizzaOrder.getSize())) {
                throw new PizzaException("Size not available");
            }

            temp.add(pizzaOrder);

            pizzaOrderRepository.save(pizzaOrder);
        }

        for (PizzaOrder pizzaOrder : temp) {
            delivery.addPizzaOrder(pizzaOrder);
        }

        deliveryRepository.save(delivery);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    public List<Delivery> getOrders() {
        return (List<Delivery>) deliveryRepository.findAll();
    }
}
