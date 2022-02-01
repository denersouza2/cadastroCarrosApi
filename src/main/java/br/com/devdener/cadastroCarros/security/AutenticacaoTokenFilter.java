package br.com.devdener.cadastroCarros.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.devdener.cadastroCarros.model.Usuario;
import br.com.devdener.cadastroCarros.repository.UsuarioRepository;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {
	private TokenService tokenService;
	private UsuarioRepository repository;
	
	

	public AutenticacaoTokenFilter(TokenService tokenService, UsuarioRepository repository) {
		super();
		this.tokenService = tokenService;
		this.repository = repository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			autenticarUsusario(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarUsusario(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario  = repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;	
		}
		return token.substring(7, token.length());
	}

}
