package com.edney.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edney.curso.entidades.Produto;
import com.edney.curso.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	
	@Autowired
	private ServicoProduto servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Produto> buscarPeloId(@PathVariable Long id) {
		Produto obj = servico.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
