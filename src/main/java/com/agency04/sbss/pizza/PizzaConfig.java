package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.MammaMia;
import com.agency04.sbss.pizza.service.Marzia;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    @Bean
    public PizzeriaService mammaMia() {
        return new MammaMia();
    }

    @Bean
    @Primary
    public PizzeriaService marzia() {
        return new Marzia();
    }
}
