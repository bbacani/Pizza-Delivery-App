package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Capricciosa;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PizzaApp {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(PizzaApp.class, args);

		PizzaDeliveryService pizzaDeliveryService = applicationContext.getBean(PizzaDeliveryService.class);

		System.out.println(pizzaDeliveryService.orderPizza(new Margherita()));

		PizzeriaService pizzeriaService = applicationContext.getBean(PizzeriaService.class);

		System.out.println(pizzeriaService.makePizza(new Capricciosa()));
	}

}
