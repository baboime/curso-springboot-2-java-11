package com.edney.curso.servicos.excecoes;

public class ExcecaoRecursoNaoEncontrato extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcecaoRecursoNaoEncontrato(Object id) {
		super("Recurso não encontrado. Id " + id);
	}

}
