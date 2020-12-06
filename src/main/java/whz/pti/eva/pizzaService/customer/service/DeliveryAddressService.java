package whz.pti.eva.pizzaService.customer.service;

import whz.pti.eva.pizzaService.customer.domain.Customer;

public interface DeliveryAddressService {
	
	void addAddress(String steet, String houseNumber, String town, String postalCode, Customer customer);
}
