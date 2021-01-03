package whz.pti.eva.pizzaService.security.service.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import whz.pti.eva.pizzaService.security.domain.CustomerCreateForm;
import whz.pti.eva.pizzaService.security.service.customer.CustomerService;


@Component
public class UserCreateFormValidator implements Validator {

    private static final Logger log = LoggerFactory.getLogger(UserCreateFormValidator.class);
    private CustomerService customerService;

    @Autowired
    public UserCreateFormValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(CustomerCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.debug("Validating {}", target);
        CustomerCreateForm form = (CustomerCreateForm) target;
        validatePasswords(errors, form);
        validateLogin(errors, form);
    }

    private void validatePasswords(Errors errors, CustomerCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password", "Unterschiedliche passwoerter eingegeben!");
        }
    }

    private void validateLogin(Errors errors, CustomerCreateForm form) {
        if (customerService.existsByLoginName(form.getLoginName())) {
            errors.reject("loginname", "Nutzer mit diesem login name existiert bereits !!!");
        }
    }
}
