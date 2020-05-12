package com.edney.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.curso.entidades.Produto;
import com.edney.curso.repositorios.RepositorioProduto;

@Service // Registra a classe como um componente do spring e tornará possível a injeção de dependência automática ao utilizar o @Autowired
public class ServicoProduto {
	
	@Autowired
	private RepositorioProduto repositorio;
	
	public List<Produto> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Produto buscarPeloId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
 
}
