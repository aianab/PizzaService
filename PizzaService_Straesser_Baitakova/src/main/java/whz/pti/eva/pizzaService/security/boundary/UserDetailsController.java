package whz.pti.eva.pizzaService.security.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import whz.pti.eva.pizzaService.common.CurrentUserUtil;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;
import whz.pti.eva.pizzaService.security.service.dto.CustomerDTO;

@Controller
public class UserDetailsController {
	CustomerService customerService;
	@Autowired
	public UserDetailsController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value = {"/user"}, method = RequestMethod.GET)
	public String getUserInfo(Model model) {
		Long customerID = CurrentUserUtil.getCurrentUserID(model);
		CustomerDTO customerDTO = customerService.getCustomerById(customerID);
		model.addAttribute("user", customerDTO);
		return "profile";
	}
}
