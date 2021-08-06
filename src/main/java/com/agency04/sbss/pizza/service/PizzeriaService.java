package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.Size;

import java.util.List;

public interface PizzeriaService {

    String getName();

    String getAddress();

    String getNumber();

    List<Pizza> getPizzas();

    List<Size> getSizes();

    String makePizza(Pizza pizza);
}
