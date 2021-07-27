package com.agency04.sbss.pizza.model;

import java.util.List;

public class Tonno implements Pizza {
    @Override
    public String getName() {
        return "Tonno";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        return List.of(
                PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.TUNA,
                PizzaIngredient.ONIONS
        );
    }
}
