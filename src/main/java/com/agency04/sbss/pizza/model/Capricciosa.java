package com.agency04.sbss.pizza.model;

import java.util.List;

public class Capricciosa implements Pizza {
    @Override
    public String getName() {
        return "Capricciosa";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        return List.of(
                PizzaIngredient.TOMATO_SAUCE,
                PizzaIngredient.MOZZARELLA,
                PizzaIngredient.HAM,
                PizzaIngredient.ARTICHOKES,
                PizzaIngredient.MUSHROOMS,
                PizzaIngredient.OLIVES
        );
    }
}
