package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		System.out.println();

		PizzaDeliveryService pizzaDeliveryService = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
		pizzaDeliveryService.orderPizza(new Margherita());

		context.close();
	}

}
