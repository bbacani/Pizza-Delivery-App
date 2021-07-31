package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.stereotype.Service;

@Service
public class MammaMia implements PizzeriaService {

    private String name;

    private String address;

    private String number;

    public MammaMia() {
        this.name = "Mamma Mia";
        this.address = "Italian Street 99, Rome";
        this.number = "01 2345 678";
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
