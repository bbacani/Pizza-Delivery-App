package com.agency04.sbss.pizza.model.pizzas;

import com.agency04.sbss.pizza.model.Ingredient;
import com.agency04.sbss.pizza.model.Pizza;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Diavola extends Pizza {
    @Override
    public String getName() {
        return "Diavola";
    }

    @Override
    public List<Ingredient> getIngredients() {
        return List.of(
                Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.SPICY_SALAMI,
                Ingredient.CHILLI_PEPPER
        );
    }
}
