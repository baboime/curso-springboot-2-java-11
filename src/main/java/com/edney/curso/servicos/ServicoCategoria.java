package com.edney.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.curso.entidades.Categoria;
import com.edney.curso.repositorios.RepositorioCategoria;

@Service // Registra a classe como um componente do spring e tornará possível a injeção de dependência automática ao utilizar o @Autowired
public class ServicoCategoria {
	
	@Autowired
	private RepositorioCategoria repositorio;
	
	public List<Categoria> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Categoria buscarPeloId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
 
}
