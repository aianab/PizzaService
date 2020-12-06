package whz.pti.eva.pizzaService.domain;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import whz.pti.eva.pizzaService.pizza.domain.Item;
import whz.pti.eva.pizzaService.pizza.domain.ItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;
import whz.pti.eva.pizzaService.pizza.domain.PizzaSize;

@SpringBootTest
public class ItemTest {
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	PizzaRepository pizzaRepo;
	
	@Test
	public void shouldSaveEntityItem() {
		Item item = new Item();
		item.setQuantity(1);
		item.setSize(PizzaSize.LARGE);
		
		Pizza pizza = new Pizza("Margarita", new BigDecimal(20), new BigDecimal(15), new BigDecimal(5));
		pizza = pizzaRepo.save(pizza);
		
		item.withPizza(pizza);
		item = itemRepo.save(item);
		Assert.notNull(item.getId(), "Item is null");
	}
}
