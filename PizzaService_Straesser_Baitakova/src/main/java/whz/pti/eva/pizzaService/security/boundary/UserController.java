package whz.pti.eva.pizzaService.security.boundary;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import whz.pti.eva.pizzaService.pizza.boundary.PizzaController;
import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.domain.CustomerCreateForm;
import whz.pti.eva.pizzaService.security.domain.Role;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;
import whz.pti.eva.pizzaService.security.service.customer.CustomerServiceImpl;
import whz.pti.eva.pizzaService.security.service.validation.UserCreateFormValidator;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
	private CustomerService customerService;
	private UserCreateFormValidator userCreateFormValidator;
	
	@Autowired
	public UserController(CustomerService customerService, UserCreateFormValidator userCreateFormValidator) {
		this.customerService = customerService;
		this.userCreateFormValidator = userCreateFormValidator;
	}
	
	@InitBinder("myform")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
	public String getRegistrationPage() {
		return "signUp";
	}
	
	@RequestMapping(value = {"/users/create"}, method = RequestMethod.POST)
	public String signUpUser(@Valid @ModelAttribute("myform") CustomerCreateForm form,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
            return "signUp";
        }
		
		customerService.create(form); 
		if(customerService.getCustomerByLoginName(form.getLoginName()).get().getRole()==null) {
			customerService.getCustomerByLoginName(form.getLoginName()).get().setRole(Role.USER);
		}
		return "signIn";
	}
	
}
