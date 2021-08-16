package com.agency04.sbss.pizza.model.pizzas;

import com.agency04.sbss.pizza.model.Ingredient;
import com.agency04.sbss.pizza.model.Pizza;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Capricciosa extends Pizza {
    @Override
    public String getName() {
        return "Capricciosa";
    }

    @Override
    public List<Ingredient> getIngredients() {
        return List.of(
                Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.HAM,
                Ingredient.ARTICHOKES,
                Ingredient.MUSHROOMS,
                Ingredient.OLIVES
        );
    }
}
