package com.agency04.sbss.pizza.model;

import java.util.List;

public class Diavola implements Pizza {
    @Override
    public String getName() {
        return "Diavola";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        return List.of(
                PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.SPICY_SALAMI,
                PizzaIngredient.CHILLI_PEPPER
        );
    }
}
