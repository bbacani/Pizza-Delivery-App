package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PizzaOrder that = (PizzaOrder) o;

        if (pizzaOrderId != that.pizzaOrderId) return false;
        if (quantity != that.quantity) return false;
        if (!Objects.equals(pizza, that.pizza)) return false;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        int result = (int) (pizzaOrderId ^ (pizzaOrderId >>> 32));
        result = 31 * result + (pizza != null ? pizza.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }
}
