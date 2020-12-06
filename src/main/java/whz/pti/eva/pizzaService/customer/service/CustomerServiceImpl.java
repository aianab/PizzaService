package whz.pti.eva.pizzaService.customer.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.customer.domain.Customer;
import whz.pti.eva.pizzaService.customer.domain.CustomerRepository;
import whz.pti.eva.pizzaService.customer.domain.DeliveryAddress;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Optional<Customer> getCustomer(Long userID) {
		Optional<Customer> customer = customerRepository.findById(userID);
		return customer;
	}
	
	@Override
	public boolean deactivateUser(Long userID) {
		Optional<Customer> customer = getCustomer(userID);
		if(customer.isPresent()) {
			customer.get().setActive(false);
			return true;
		}
		return false;
	}

	@Override
	public void addCustomer(String firstName, String lastName, String login, String passwordHash, DeliveryAddress deliveryAddress) {
		Customer customer = new Customer(firstName, lastName, login, passwordHash, deliveryAddress);
		customerRepository.save(customer);
	}



}
