package whz.pti.eva.pizzaService.pizza.domain;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Entity;
import whz.pti.eva.pizzaService.config.BaseEntity;

@Entity
public class Pizza extends BaseEntity<UUID> {
	
	private String pizzaName;
	private BigDecimal priceLarge;
	private BigDecimal priceMedium;
	private BigDecimal priceSmall;
	
	public Pizza() {
		
	}
	
	public Pizza(String name, BigDecimal priceL, BigDecimal priceM, BigDecimal priceS) {
		this.pizzaName = name;
		this.priceLarge = priceL;
		this.priceMedium = priceM;
		this.priceSmall = priceS;
	}
	
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public BigDecimal getPriceLarge() {
		return priceLarge;
	}
	public void setPriceLarge(BigDecimal priceLarge) {
		this.priceLarge = priceLarge;
	}
	public BigDecimal getPriceMedium() {
		return priceMedium;
	}
	public void setPriceMedium(BigDecimal priceMedium) {
		this.priceMedium = priceMedium;
	}
	public BigDecimal getPriceSmall() {
		return priceSmall;
	}
	public void setPriceSmall(BigDecimal priceSmall) {
		this.priceSmall = priceSmall;
	}
}
