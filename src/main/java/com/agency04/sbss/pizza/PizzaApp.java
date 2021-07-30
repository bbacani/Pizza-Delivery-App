package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaApp {

	public static void main(String[] args) {

		SpringApplication.run(PizzaApp.class, args);

		PizzaDeliveryService pizzaDeliveryService = new PizzaDeliveryService();

		System.out.println(pizzaDeliveryService.orderPizza(new Margherita()));
	}

}
