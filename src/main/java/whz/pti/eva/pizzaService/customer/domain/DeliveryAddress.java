package whz.pti.eva.pizzaService.customer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import whz.pti.eva.pizzaService.config.BaseEntity;

@Entity
public class DeliveryAddress extends BaseEntity<Long>{

	private String street;
	private String houseNumber;
	private String town;
	private String postalCode;
	
	@ManyToMany
	private List<Customer> customer;

	public DeliveryAddress( String street, String houseNumber, String town, String postalCode,
			Customer customer) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.town = town;
		this.postalCode = postalCode;
		addCustomer(customer);
	}
	
	public void addCustomer(Customer customer) {
		this.customer.add(customer);
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getTown() {
		return town;
	}

	public String getPostalCode() {
		return postalCode;
	}

}
