package whz.pti.eva.pizzaService.pizza.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import whz.pti.eva.pizzaService.config.BaseEntity;

@Entity
public class Item extends BaseEntity<UUID>{

	private int quantity;
	
	@ManyToOne	
	private Pizza pizza;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	
	public Item() {}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Pizza getPizza() {
		return pizza;
	}


	public Item withPizza(Pizza pizza) {
		this.pizza = pizza;
		return this;
	}


	public PizzaSize getSize() {
		return size;
	}


	public void setSize(PizzaSize size) {
		this.size = size;
	}
}
