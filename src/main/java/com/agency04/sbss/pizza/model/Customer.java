package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String username;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private CustomerDetails customerDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Delivery> deliveries;

    public Customer() {
    }

    public Customer(String username, CustomerDetails customerDetails, List<Delivery> deliveries) {
        this.username = username;
        this.customerDetails = customerDetails;
        this.deliveries = deliveries;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
        this.customerDetails.setCustomer(this);
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
