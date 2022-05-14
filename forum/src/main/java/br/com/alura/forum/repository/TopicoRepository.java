package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	//spring monta a query automaticamente para o titulo declarando este método
	List<Topico> findByTitulo(String nomeCurso);

	//Cria tbm para o atributo Nome da FK(relacionamento) Curso que tem em Topico:
	List<Topico> findByCurso_Nome(String nomeCurso);
	
	//Nao seguindo o padrao de nomenclatura do Spring
	//@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	//List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
	
}
