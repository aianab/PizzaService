package whz.pti.praktikum_08.payment.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import whz.pti.praktikum_08.payment.dto.AccountResponseDTO;
import whz.pti.praktikum_08.payment.dto.UserDTO;
import whz.pti.praktikum_08.payment.service.PayUserService;

@RestController
public class UserController {

    @Autowired
    private PayUserService payUserService;

    @PostMapping("/users")
    public ResponseEntity<AccountResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
       String returnStatus =  payUserService.openAccount(userDTO.getUserId(), userDTO.getUserLogin());
        if (returnStatus.equals("created")) {
        	return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("User created: " + userDTO.getUserLogin()));
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AccountResponseDTO(returnStatus));
    }
}