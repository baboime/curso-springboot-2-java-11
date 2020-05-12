package com.edney.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edney.curso.entidades.Pedido;
import com.edney.curso.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {
	
	@Autowired
	private ServicoPedido servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		List<Pedido> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Pedido> buscarPeloId(@PathVariable Long id) {
		Pedido obj = servico.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
