package whz.pti.eva.pizzaService.config;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import whz.pti.eva.pizzaService.cart.domain.CartRepository;
import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.ItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.Ordered;
import whz.pti.eva.pizzaService.pizza.domain.OrderedItem;
import whz.pti.eva.pizzaService.pizza.domain.OrderedItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.OrderedRepository;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;
@Component
public class InitializeDB {

	@Autowired
	PizzaRepository pizzaRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderedRepository orderedRepo;
	
	@Autowired
	OrderedItemRepository orderedItemRepo;
	/*
	@PostConstruct@Transactional
	public void initPizzaItemMany2OneUni() {
		Pizza pizza1 = new Pizza("Margarita", new BigDecimal(20), new BigDecimal(15), new BigDecimal(5));
		pizzaRepo.save(pizza1);
		
		Item item1 = new Item();
		item1.withPizza(pizza1);
		itemRepo.save(item1);
		
		Pizza pizza2 = new Pizza("Tonno", new BigDecimal(17), new BigDecimal(12), new BigDecimal(3));
		pizzaRepo.save(pizza2);
		
		Item item2 = new Item();
		item2.withPizza(pizza2);;
		itemRepo.save(item2);
		
		Pizza pizza3 = new Pizza("Napoli", new BigDecimal(22), new BigDecimal(17), new BigDecimal(6));
		pizzaRepo.save(pizza3);
		
		Item item3 = new Item();
		item3.withPizza(pizza3);
		itemRepo.save(item3);
	}
	
	@PostConstruct@Transactional
	public void initCartItemOne2ManyUni() {
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		itemRepo.save(item1);
		itemRepo.save(item2);
		itemRepo.save(item3);
		
		Cart cart1 = new Cart();
		cart1.addItem(item1).addItem(item2).addItem(item3);
		cartRepo.save(cart1);
	}
	
//	@Transactional
//	 public void initItemPizzaSizeOne2OneUni() {
//        Item item = new Item();
//        item.setItemId("Margarita");
//        item.setSize(PizzaSize.MEDIUM);
//		itemRepo.save(item);
//    }
//	@Transactional
//	 public void initOrderedItemPizzaSizeOne2OneUni() {
//       OrderedItem orderedItem = new OrderedItem();
//       orderedItem.setName("Margarita");
//       orderedItem.setSize(PizzaSize.MEDIUM);
//       orderedItemRepo.save(orderedItem);
//   }
	
	@PostConstruct@Transactional
	public void initOderedOderedItemOne2ManyUni() {
		OrderedItem orderedItem1 = new OrderedItem();
		OrderedItem orderedItem2 = new OrderedItem();
		OrderedItem orderedItem3 = new OrderedItem();
		orderedItemRepo.save(orderedItem1);
		orderedItemRepo.save(orderedItem2);
		orderedItemRepo.save(orderedItem3);
		
		Ordered ordered = new Ordered();
		ordered.addOrderedItems(orderedItem1).addOrderedItems(orderedItem2).addOrderedItems(orderedItem3);
		orderedRepo.save(ordered);		
	}
	*/
	
	@PostConstruct
	private void init() {
		Pizza pizza1 = new Pizza("Margarita", new BigDecimal(20), new BigDecimal(15), new BigDecimal(5));
		pizzaRepo.save(pizza1);
		Pizza pizza2 = new Pizza("Tonno", new BigDecimal(17), new BigDecimal(12), new BigDecimal(3));
		pizzaRepo.save(pizza2);
		Pizza pizza3 = new Pizza("Napoli", new BigDecimal(22), new BigDecimal(17), new BigDecimal(6));
		pizzaRepo.save(pizza3);
	}
}
