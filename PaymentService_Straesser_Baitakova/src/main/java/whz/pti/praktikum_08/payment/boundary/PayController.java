package whz.pti.praktikum_08.payment.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import whz.pti.praktikum_08.payment.dto.AccountResponseDTO;
import whz.pti.praktikum_08.payment.dto.TransferDTO;
import whz.pti.praktikum_08.payment.service.PayUserService;

@RestController
public class PayController {

    PayUserService payUserService;

    @Autowired
    public PayController(PayUserService payUserService) {
        this.payUserService = payUserService;
    }

    @PostMapping(value = "/pay")
    public ResponseEntity<AccountResponseDTO> transfer(@RequestBody TransferDTO input) {
        int amount = input.getAmount();
        String returnStatus = null;
        returnStatus = payUserService.payForOrder(input.getUserId(), amount);

        if (returnStatus.equals("okay"))
            return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Transfer ist erfolgreich durchgefuehrt"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AccountResponseDTO(returnStatus));
    }
    
    @PostMapping(value = "/upload")
    public ResponseEntity<AccountResponseDTO> upload(@RequestBody TransferDTO input) {
        int amount = input.getAmount();
        String returnStatus = null;
        returnStatus = payUserService.uploadMoney(input.getUserId(), amount);

        if (returnStatus.equals("success"))
            return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Aufladung ist erfolgreich durchgefuehrt"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AccountResponseDTO(returnStatus));
    }

    @GetMapping(value = "/balance/{userId}")
    public ResponseEntity<AccountResponseDTO> listAccountBalance(@PathVariable String userId) {
        int balance = payUserService.getAccountBalanceByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Kontostand betraegt " + balance));
    }
}