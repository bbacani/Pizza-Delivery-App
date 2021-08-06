package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Capricciosa;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class Marzia implements PizzeriaService {

    @Value("${foo.name}")
    private String name;

    @Value("${foo.address}")
    private String address;

    @Value("${foo.number}")
    private String number;

    private List<Pizza> pizzas = List.of(new Margherita(), new Capricciosa());

    @Value("${foo.sizes}")
    private List<Size> sizes;

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
        return getName() + ": Making " + pizza.getName() + "\n";
    }
}
