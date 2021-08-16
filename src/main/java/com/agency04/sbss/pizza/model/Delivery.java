package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {

    @ManyToOne
    private Customer customer;

    @Id
    private Date submissionDate;

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

    public Delivery() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public void addPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrders.add(pizzaOrder);
        pizzaOrder.setDelivery(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (!Objects.equals(customer, delivery.customer)) return false;
        if (!Objects.equals(submissionDate, delivery.submissionDate))
            return false;
        return Objects.equals(pizzaOrders, delivery.pizzaOrders);
    }

    @Override
    public int hashCode() {
        int result = customer != null ? customer.hashCode() : 0;
        result = 31 * result + (submissionDate != null ? submissionDate.hashCode() : 0);
        result = 31 * result + (pizzaOrders != null ? pizzaOrders.hashCode() : 0);
        return result;
    }
}
