package com.agency04.sbss.pizza.model;

import java.util.List;

public class MenuResponse {
    private List<Size> sizes;

    private List<Pizza> pizzas;

    public MenuResponse() {
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
