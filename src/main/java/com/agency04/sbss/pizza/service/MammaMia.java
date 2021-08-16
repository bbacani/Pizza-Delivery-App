package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.model.pizzas.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MammaMia implements PizzeriaService {

    private String name;

    private String address;

    private String number;

    private List<Pizza> pizzas;

    private List<Size> sizes;

    public MammaMia() {
        this.name = "Mamma Mia";
        this.address = "Italian Street 99, Rome";
        this.number = "01 2345 678";
        this.pizzas = List.of(new Capricciosa(), new Margherita(), new Diavola(), new Tonno());
        this.sizes = List.of(Size.SMALL, Size.MEDIUM, Size.LARGE);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    @Override
    public String makePizza(Pizza pizza) {
        return getName() + ": Making " + pizza.getName();
    }
}
