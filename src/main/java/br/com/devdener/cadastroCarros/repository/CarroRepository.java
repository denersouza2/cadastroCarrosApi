package br.com.devdener.cadastroCarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devdener.cadastroCarros.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
