package com.agency04.sbss.pizza.api;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    private final PizzaDeliveryService pizzaDeliveryService;

    @Autowired
    public DeliveryController(PizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @PostMapping("/delivery/order")
    public ResponseEntity<HttpStatus> postOrder(@RequestBody Delivery delivery) {

        if (!pizzaDeliveryService.getCustomerRepository().existsById(delivery.getCustomer().getUsername())) {
            throw new PizzaException("Customer not registered");
        }

        delivery.setSubmissionDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));

        List<PizzaOrder> temp = new ArrayList<>();

        for (PizzaOrder pizzaOrder : delivery.getPizzaOrders()) {
            pizzaOrder.setPizza(pizzaDeliveryService.getPizzaRepository()
                    .findById(pizzaOrder.getPizza().getName())
                    .orElseThrow()
            );

            if (pizzaOrder.getQuantity() <= 0 || pizzaOrder.getQuantity() > 10) {
                throw new PizzaException("Please insert valid quantity (1-10)");
            }

            if (!pizzaDeliveryService.getPizzeriaService().getSizes().contains(pizzaOrder.getSize())) {
                throw new PizzaException("Size not available");
            }

            temp.add(pizzaOrder);

            pizzaDeliveryService.getPizzaOrderRepository().save(pizzaOrder);
        }

        for (PizzaOrder pizzaOrder : temp) {
            delivery.addPizzaOrder(pizzaOrder);
        }

        pizzaDeliveryService.getDeliveryRepository().save(delivery);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<Delivery> getOrders() {
        return (List<Delivery>) pizzaDeliveryService.getDeliveryRepository().findAll();
    }
}
