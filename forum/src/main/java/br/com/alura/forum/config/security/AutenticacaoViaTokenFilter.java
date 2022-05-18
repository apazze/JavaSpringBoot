package br.com.alura.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

// chamado uma única vez a cada requisição
// Add filtro em SecurityConfigurations.configure
public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{
	
	
	private TokenService tokenService;
	
	
	//injetar manualmente
	
	public AutenticacaoViaTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		boolean valido = tokenService.isTokenValido(token);
		
		System.out.println("Token Válido? " + valido);
		
		//System.out.println("Token recuperado do cabecalho Authorization => " + token);
		
		
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
			return null;
		}
							   // pega a partir de Bearer{espaço}
		return token.substring(7, token.length());
	}

}
