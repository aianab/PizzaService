package whz.pti.praktikum_08.payment.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import whz.pti.praktikum_08.payment.dto.AccountResponseDTO;
import whz.pti.praktikum_08.payment.dto.TransferDTO;
import whz.pti.praktikum_08.payment.service.PayUserException;
import whz.pti.praktikum_08.payment.service.PayUserService;

@RestController
public class PayController {

	PayUserService payUserService;
	
	@Autowired
	public PayController(PayUserService payUserService) {
		this.payUserService = payUserService;
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> transfer(@PathVariable String userId, @RequestBody TransferDTO input) {
        int amount = input.getAmount();
        String returnStatus = null;
        returnStatus = payUserService.payForOrder(userId, amount);

        if (returnStatus.equals("okay"))
            return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Transfer ist erfolgreich durchgefuehrt"));
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AccountResponseDTO(returnStatus));
    }
	
	@RequestMapping(value = "/balance") //, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAccountBalance(@PathVariable String userId) {
        int balance = payUserService.getAccountBalanceByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Kontostand betraegt " + balance));
        }
}
