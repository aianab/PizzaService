package whz.pti.eva.pizzaService.cart.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.cart.service.CartService;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;


@Controller
public class CartController {
	private CartService cartService;
	
	@Autowired
	 public CartController(CartService cartService) {
		 this.cartService = cartService;
	 }
	
	 @RequestMapping(value ="/cart")
	 public String listAllPizza(Model model) {
		 return "warenkorb";
	 }
}
