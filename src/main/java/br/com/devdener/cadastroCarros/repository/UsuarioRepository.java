package br.com.devdener.cadastroCarros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devdener.cadastroCarros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
