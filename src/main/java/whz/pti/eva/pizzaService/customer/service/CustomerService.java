package whz.pti.eva.pizzaService.customer.service;

import java.util.Optional;

import whz.pti.eva.pizzaService.customer.domain.Customer;
import whz.pti.eva.pizzaService.customer.domain.DeliveryAddress;


public interface CustomerService {
	public Optional<Customer> getCustomer(Long userID);
	public boolean deactivateUser(Long userID);
	public void addCustomer(String firstName, String lastName, String loginName, String passwordHash, DeliveryAddress deliveryAddress);
}
