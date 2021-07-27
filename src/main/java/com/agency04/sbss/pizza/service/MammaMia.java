package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MammaMia implements PizzeriaService {

    @Value("Mamma Mia")
    private String name;

    @Value("Italian Street 99, Rome")
    private String address;

    @Value("01 2345 678")
    private String number;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String makePizza(Pizza pizza) {
        return getName() + ": Making " + pizza.getName();
    }
}
