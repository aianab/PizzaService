package whz.pti.eva.pizzaService.pizza.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.ItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;

@Service
public class ItemServiceImpl implements ItemService{

	private ItemRepository itemRepository; 
	private PizzaServiceImpl pizzaService; 
	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository, PizzaServiceImpl pizzaService) {
		this.itemRepository = itemRepository; 
		this.pizzaService = pizzaService; 
	}
	
}
