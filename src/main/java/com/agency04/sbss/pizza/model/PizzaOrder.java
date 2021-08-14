package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PizzaOrder {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pizzaOrderId;

    @ManyToOne
    private Pizza pizza;

    private int quantity;

    private Size size;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "delivery_submission_date")
    private Delivery delivery;

    public PizzaOrder() {
    }

    public long getPizzaOrderId() {
        return pizzaOrderId;
    }

    public void setPizzaOrderId(long pizzaOrderId) {
        this.pizzaOrderId = pizzaOrderId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public PizzaOrder setPizza(Pizza pizza) {
        this.pizza = pizza;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
