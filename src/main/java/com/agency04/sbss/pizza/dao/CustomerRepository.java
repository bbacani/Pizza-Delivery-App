package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
