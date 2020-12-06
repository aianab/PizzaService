package whz.pti.eva.pizzaService.cart.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {
	
}
