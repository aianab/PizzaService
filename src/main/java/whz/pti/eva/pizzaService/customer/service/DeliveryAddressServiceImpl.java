package whz.pti.eva.pizzaService.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import whz.pti.eva.pizzaService.customer.domain.Customer;
import whz.pti.eva.pizzaService.customer.domain.DeliveryAddress;
import whz.pti.eva.pizzaService.customer.domain.DeliveryAdressRepository;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
	private DeliveryAdressRepository deliveryAdressRepository;
	
	@Autowired
	public DeliveryAddressServiceImpl(DeliveryAdressRepository deliveryAdressRepository) {
		this.deliveryAdressRepository = deliveryAdressRepository;
	}
	
	@Override
	public void addAddress(String steet, String houseNumber, String town, String postalCode, Customer customer) {
		DeliveryAddress deliveryAdress = new DeliveryAddress(steet, houseNumber, town, postalCode, customer);
		deliveryAdressRepository.save(deliveryAdress);
	}
}
