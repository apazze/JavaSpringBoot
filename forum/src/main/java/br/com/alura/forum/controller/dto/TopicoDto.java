package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<TopicoDto> converter(Page<Topico> topicos) {
		
		//Antes do java 8, teria que fazer foreach, para cada item, new TopicoDto, guardar em lista e dps devolver
		
		//java 8 - map de topico para topicoDto
		//									   new - para cada um chama o construtor acima que recebe tópico como parâmetro
		//return topicos.stream().map(TopicoDto::new).collect(Collectors.toList()); // e transforma numa lista
		
		return topicos.map(TopicoDto::new);
	}

}
