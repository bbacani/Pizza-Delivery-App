package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final PizzaDeliveryService pizzaDeliveryService;

    @Autowired
    public AppStartupRunner(PizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        pizzaDeliveryService.setPizzas();

        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer(
                "marko",
                null,
                new ArrayList<>()
        );

        customer1.setCustomerDetails(new CustomerDetails(
                "Marko",
                "Markovic",
                "012345678"
        ));

        Customer customer2 = new Customer(
                "ivo",
                null,
                new ArrayList<>()
        );

        customer2.setCustomerDetails(new CustomerDetails(
                "Ivo",
                "Ivic",
                "999888777"
        ));

        customers.add(customer1);
        customers.add(customer2);

        pizzaDeliveryService.saveCustomers(customers);
    }
}
