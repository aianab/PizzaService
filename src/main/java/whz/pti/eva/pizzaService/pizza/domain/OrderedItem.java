package whz.pti.eva.pizzaService.pizza.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import whz.pti.eva.pizzaService.config.BaseEntity;

@Entity
public class OrderedItem extends BaseEntity<UUID>{

	private UUID pizzaId;
	private String name;
	private int quantity;
	private UUID userId;
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize size;
	
	public OrderedItem() {
		 
	}
	public UUID getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Pizza pizza) {
		this.pizzaId = pizza.getId();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return price;
	}
}
