package whz.pti.eva.pizzaService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaServiceStraesserBaitakovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaServiceStraesserBaitakovaApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init() {
        return (evt) -> {
        	System.out.println("Test");
        };
	}

}
