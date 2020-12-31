package whz.pti.eva.pizzaService.security.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import whz.pti.eva.pizzaService.security.domain.Customer;
import whz.pti.eva.pizzaService.security.domain.CustomerCreateForm;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
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
    public String signUpUser(CustomerCreateForm model) {
        Customer customer = customerService.create(model);
        log.info("USER CREATED.");
        return "signIn";
    }

}
