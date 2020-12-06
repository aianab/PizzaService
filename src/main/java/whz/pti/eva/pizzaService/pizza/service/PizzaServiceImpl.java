package whz.pti.eva.pizzaService.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizzaService.pizza.domain.Pizza;
import whz.pti.eva.pizzaService.pizza.domain.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService {

	private PizzaRepository pizzaRepository;

	@Autowired
	public PizzaServiceImpl(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	} 
	
	
	public Optional<Pizza> findById(Long id) {
		return pizzaRepository.findById(id); 
	}


	@Override
	public List<Pizza> listOfAllPizzas() {
		return pizzaRepository.findAll();
	}
	

}

