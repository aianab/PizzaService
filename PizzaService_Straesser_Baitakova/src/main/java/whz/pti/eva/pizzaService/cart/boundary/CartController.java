package whz.pti.eva.pizzaService.cart.boundary;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import whz.pti.eva.pizzaService.cart.domain.Cart;
import whz.pti.eva.pizzaService.cart.service.CartService;
import whz.pti.eva.pizzaService.common.CurrentUserUtil;
import whz.pti.eva.pizzaService.order.domain.Ordered;
import whz.pti.eva.pizzaService.order.domain.OrderedItem;
import whz.pti.eva.pizzaService.order.service.OrderedItemService;
import whz.pti.eva.pizzaService.order.service.OrderedService;
import whz.pti.eva.pizzaService.pizza.boundary.PizzaController;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;


@Controller
public class CartController {
	private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
	private CartService cartService;
	private OrderedService orderedService;
	private OrderedItemService orderedItemService;
	private CustomerService customerService;
	@Autowired
	 public CartController(CartService cartService, OrderedService orderedService, OrderedItemService orderedItemService) {
		 this.cartService = cartService;
		 this.orderedService = orderedService;
		 this.orderedItemService = orderedItemService;
	 }
	
	 @RequestMapping(value ="/cart")
	 public String listAllPizza(Model model) {
		 Long customerID = CurrentUserUtil.getCurrentUserID(model);
		 Optional<Cart> cart = cartService.getCart(customerID);
		 cart.ifPresent( cartTemp -> {
			 List<Item> items = cartTemp.getItemList();
			 BigDecimal totalPrice = BigDecimal.valueOf(items.stream().collect(Collectors.summingDouble(item -> item.getPrice().doubleValue())));
			 model.addAttribute("totalPrice", totalPrice);
			 model.addAttribute("listOfAllItems", items);
		 });
		 return "cart";
	 }
	 
	 @RequestMapping(value ="/order")
	 public String order(Model model) {
		 Long customerID = CurrentUserUtil.getCurrentUserID(model);
		 Cart cart = cartService.getCart(customerID).get();
		 Ordered ordered = new Ordered();
		 ordered.setUserId(customerID);
		 cart.getItemList().forEach(item -> {
			 OrderedItem oItem = orderedItemService.newOrderedItem(item.getPizza().getPizzaName(), item.getPizza().getId(), item.getQuantity(), customerID, item.getSize());
			 orderedService.addOreredItem(ordered, oItem);
		 });
		 cartService.clearCart(cart);
		 return "redirect:menu";
	 }
	 
}
