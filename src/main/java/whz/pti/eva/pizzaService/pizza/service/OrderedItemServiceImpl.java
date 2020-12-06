package whz.pti.eva.pizzaService.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.OrderedItemRepository;
import whz.pti.eva.pizzaService.pizza.domain.OrderedRepository;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {
	
	private OrderedItemRepository orderedItemRepository;

	@Autowired
	public OrderedItemServiceImpl(OrderedItemRepository orderedItemRepository) {
		this.orderedItemRepository = orderedItemRepository;
	} 
}
