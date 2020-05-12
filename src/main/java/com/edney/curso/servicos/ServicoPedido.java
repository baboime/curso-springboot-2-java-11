package com.edney.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.curso.entidades.Pedido;
import com.edney.curso.repositorios.RepositorioPedido;

@Service // Registra a classe como um componente do spring e tornará possível a injeção de dependência automática ao utilizar o @Autowired
public class ServicoPedido {
	
	@Autowired
	private RepositorioPedido repositorio;
	
	public List<Pedido> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Pedido buscarPeloId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
 
}
