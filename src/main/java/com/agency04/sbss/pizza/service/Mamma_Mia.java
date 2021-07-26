package com.agency04.sbss.pizza.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "mamma_mia")
public class Mamma_Mia implements PizzeriaService {

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
}
