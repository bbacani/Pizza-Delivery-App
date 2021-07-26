package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

public interface PizzeriaService {

    String getName();

    String getAddress();

    default String makePizza(Pizza pizza) {
        return getName() + ": Making " + pizza.getName();
    }
}
