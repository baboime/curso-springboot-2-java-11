package com.edney.curso.recursos.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.edney.curso.servicos.excecoes.ExcecaoRecursoNaoEncontrato;

@ControllerAdvice
public class TratamentoDeErro {
	
	@ExceptionHandler(ExcecaoRecursoNaoEncontrato.class)
	public ResponseEntity<PadraoDeErro> recursoNaoEncontrado(ExcecaoRecursoNaoEncontrato e, HttpServletRequest requisicao) {
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		PadraoDeErro padraoErro = new PadraoDeErro(Instant.now(), status.value(), erro, e.getMessage(), requisicao.getRequestURI());
		return ResponseEntity.status(status).body(padraoErro);
	}
}
