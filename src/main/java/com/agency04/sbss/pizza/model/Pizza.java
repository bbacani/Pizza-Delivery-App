package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pizza {

    @Id
    private String name;

    @Column
    @Enumerated
    @ElementCollection(targetClass = Ingredient.class)
    private List<Ingredient> ingredients;

    @JsonIgnore
    @OneToMany(mappedBy = "pizza")
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

    public Pizza() {
        this.name = this.getClass().getSimpleName();
    }

    public Pizza(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }
}
