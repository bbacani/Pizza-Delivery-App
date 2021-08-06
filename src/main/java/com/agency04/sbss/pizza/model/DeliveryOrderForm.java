package com.agency04.sbss.pizza.model;

public class DeliveryOrderForm {

    private String username;

    private String pizza;

    private Size size;

    private int quantity;

    public DeliveryOrderForm() {
    }

    public DeliveryOrderForm(String username, String pizza, Size size, int quantity) {
        this.username = username;
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
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
