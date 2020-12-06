package whz.pti.eva.pizzaService.cart.service;


import java.util.Optional;

import whz.pti.eva.pizzaService.cart.domain.Cart;

public interface CartService {

	public Optional<Cart> getCart(Long id);
		
}
