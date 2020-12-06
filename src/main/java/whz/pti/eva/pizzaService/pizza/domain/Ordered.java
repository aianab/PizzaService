package whz.pti.eva.pizzaService.pizza.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import whz.pti.eva.pizzaService.config.BaseEntity;

@Entity
public class Ordered extends BaseEntity<UUID>{
 
	private int numberOfItems;
	private UUID userId;
	
	@OneToMany
	private List<OrderedItem> orderedItems;

	public Ordered() {
		this.orderedItems = new ArrayList<OrderedItem>();
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public List<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public Ordered addOrderedItems(OrderedItem orderedItem) {
		orderedItems.add(orderedItem);
		return this;
	}

}
