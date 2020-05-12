package com.edney.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.curso.entidades.Usuario;
import com.edney.curso.repositorios.RepositorioUsuario;

@Service // Registra a classe como um componente do spring e tornará possível a injeção de dependência automática ao utilizar o @Autowired

public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscarPeloId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
 
}
