package com.edney.curso.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.edney.curso.entidades.Usuario;
import com.edney.curso.repositorios.RepositorioUsuario;
import com.edney.curso.servicos.excecoes.ExcecaoBancoDeDados;
import com.edney.curso.servicos.excecoes.ExcecaoRecursoNaoEncontrato;

@Service // Registra a classe como um componente do spring e tornará possível a injeção de dependência automática ao utilizar o @Autowired
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscarPeloId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ExcecaoRecursoNaoEncontrato(id));
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void excluir(Long id) {
		try {
			repositorio.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ExcecaoRecursoNaoEncontrato(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new ExcecaoBancoDeDados(e.getMessage()); 
		}
		
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		try {
			Usuario entidade = repositorio.getOne(id);
			atualizarDados(entidade, obj);
			return repositorio.save(entidade);
		}
		catch (EntityNotFoundException e) {
			throw new ExcecaoRecursoNaoEncontrato(id);
		}
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
