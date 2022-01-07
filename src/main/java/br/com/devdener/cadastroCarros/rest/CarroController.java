package br.com.devdener.cadastroCarros.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdener.cadastroCarros.model.Carro;
import br.com.devdener.cadastroCarros.repository.CarroRepository;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin("*")
public class CarroController {
	
	@Autowired
	private CarroRepository repository;

	@PostMapping
	@RequestMapping("salvar")
	public Carro salvar(@RequestBody Carro carro) {
		return repository.save(carro);
	}
}
