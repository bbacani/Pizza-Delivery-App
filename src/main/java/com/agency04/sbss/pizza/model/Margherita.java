package com.agency04.sbss.pizza.model;

import java.util.List;

public class Margherita implements Pizza {
    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        return List.of(
                PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.OREGANO
        );
    }
}
