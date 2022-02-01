package br.com.devdener.cadastroCarros.rest;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.devdener.cadastroCarros.model.Carro;
import br.com.devdener.cadastroCarros.repository.CarroRepository;


@RestController
@RequestMapping("/api/carro")
@CrossOrigin("*")
public class CarroController {
	@Autowired
	private CarroRepository repository;
	
	@PostMapping("save")
	public Carro save (@RequestBody @Valid Carro carro) {
		return repository.save(carro);
	}
	
	@GetMapping("getAll")
	public Page<Carro> getAll(@PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao) {
		return repository.findAll(paginacao);
	}
	
	@GetMapping("getById/{id}")
	public Carro getById(@PathVariable Long id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("update/{id}")
	public Carro update(@PathVariable Long id, @RequestBody Carro carroRequest) {
		return repository.findById(id).map(carro ->{
			if (carroRequest.getDescricao() != null) {
				carro.setDescricao(carroRequest.getDescricao());
			}
			if (carroRequest.getAno() != null) { 
				carro.setAno(carroRequest.getAno());
			}
			repository.save(carro);
			return carro;
		}).orElse(null);
	}
	
}
