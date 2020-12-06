package whz.pti.eva.pizzaService.pizza.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
}
