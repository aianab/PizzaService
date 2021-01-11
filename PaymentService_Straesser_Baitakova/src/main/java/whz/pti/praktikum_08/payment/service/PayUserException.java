package whz.pti.praktikum_08.payment.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User is not found")
public class PayUserException extends RuntimeException {

    public PayUserException(String exception) {
        super(exception);
    }
}