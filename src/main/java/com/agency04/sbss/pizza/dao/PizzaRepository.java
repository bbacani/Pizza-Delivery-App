package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, String> {
}
