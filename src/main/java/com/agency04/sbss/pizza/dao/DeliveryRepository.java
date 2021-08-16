package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Date> {
}
