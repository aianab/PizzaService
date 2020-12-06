package whz.pti.eva.pizzaService.pizza.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import whz.pti.eva.pizzaService.cart.service.CartService;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.service.PizzaService;



@Controller
public class PizzaController {
	
	 private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
	 private CartService cartService;
	 private PizzaService pizzaService;
	 
	 @Autowired
	 public PizzaController(CartService cartService, PizzaService pizzaService) {
		 this.cartService = cartService;
		 this.pizzaService = pizzaService;
	 }
	 
	 @RequestMapping(value ="/bestellung")
	 public String listAllPizza(Model model) {
		 List<Pizza> listOfAllPizzas = pizzaService.listOfAllPizzas();
		 System.out.println(listOfAllPizzas.toString());
		 model.addAttribute("listOfAllPizzas",listOfAllPizzas);
		 return "bestellung";
	 }
	 
}
