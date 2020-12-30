package whz.pti.eva.pizzaService.security.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.domain.CustomerCreateForm;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;
import whz.pti.eva.pizzaService.security.service.customer.CustomerServiceImpl;

@Controller
public class UserController {
	
	private CustomerService customerService;
	
	@Autowired
	public UserController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
	public String getRegistrationPage() {
		return "signUp";
	}
	
	@RequestMapping(value = {"/users/create"}, method = RequestMethod.POST)
	public String signUpUser(CustomerCreateForm model){
		Customer customer =  customerService.create(model); 
		System.out.println(customer);
		return "signIn";
	}
	
}
