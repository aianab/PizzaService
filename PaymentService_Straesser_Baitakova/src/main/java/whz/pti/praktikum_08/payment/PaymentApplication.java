package whz.pti.praktikum_08.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import whz.pti.praktikum_08.payment.service.PayUserService;

@SpringBootApplication
public class PaymentApplication {

    @Autowired
    PayUserService payUserService;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initUser() {
        payUserService.openAccount("testUser", "testLogin");
    }
}