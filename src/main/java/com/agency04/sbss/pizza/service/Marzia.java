package com.agency04.sbss.pizza.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Marzia implements PizzeriaService {

    @Value("${foo.name}")
    private String name;

    @Value("${foo.address}")
    private String address;

    @Value("${foo.number}")
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
}
