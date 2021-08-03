package com.agency04.sbss.pizza.model;

public class Order {

    private Customer customer;

    private Pizza pizza;

    private Size size;

    private int quantity;

    public Order() {
    }

    public Order(Customer customer, Pizza pizza, Size size, int quantity) {
        this.customer = customer;
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
